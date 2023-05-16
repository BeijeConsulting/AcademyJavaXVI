package it.beije.beijeJet.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.beijeJet.dto.FlightDTO;
import it.beije.beijeJet.dto.TotalFlightDTO;
import it.beije.beijeJet.dto.TotalFlightDTO2;
import it.beije.beijeJet.model.Flight;
import it.beije.beijeJet.repository.AirportRepository;
import it.beije.beijeJet.repository.FlightRepository;

@Service
public class SearchService {

	@Autowired
	private FlightRepository flightRepo;

	@Autowired
	private AirportRepository airportRepo;

	public List<TotalFlightDTO> getByDate(FlightDTO dto) {

		String date = dto.getTimeDeparture();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dob = LocalDate.parse(date, formatter);

		Integer idAirportDeparture = dto.getIdAirportDeparture();
		Integer idAirportArrival = dto.getIdAirportArrival();
		System.out.println(idAirportDeparture);
		System.out.println(idAirportArrival);

		List<Flight> fl = flightRepo.getFlightDate(dob, idAirportDeparture, idAirportArrival);

		System.out.println(fl);

		List<TotalFlightDTO> lista = new ArrayList<>();

		for (Flight f : fl) {
			TotalFlightDTO flightDto = new TotalFlightDTO();
			flightDto.setAirportArrival(airportRepo.findNameByIdAirport(f.getAirportArrival()));
			flightDto.setIdFlight(f.getIdFlight());
			flightDto.setAirportDeparture(airportRepo.findNameByIdAirport(f.getAirportDeparture()));
			flightDto.setTimeDeparture(f.getTimeDeparture());
			flightDto.setTimeArrival(f.getTimeArrival());
			flightDto.setCost(f.getCost());
			flightDto.setMax_capacity(f.getMaxCapacity());
			flightDto.setCompany(f.getCompany());
			lista.add(flightDto);
		}

		return lista;
	}
	
	public List<TotalFlightDTO2> getByDate2(FlightDTO dto) {
		String date = dto.getTimeDeparture();

		System.out.println("Data: "+date);
		date = convertDateString(date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dob = LocalDate.parse(date, formatter);

		Integer idAirportDeparture = dto.getIdAirportDeparture();
		Integer idAirportArrival = dto.getIdAirportArrival();
		System.out.println(idAirportDeparture);
		System.out.println(idAirportArrival);

		List<Flight> fl = flightRepo.getFlights(dob, idAirportDeparture);
//TODO vedi formato DOB giusto tipo db e poi sistema getFlightDate in modo che gestisca gli orari
		System.out.println(fl);

		List<TotalFlightDTO2> lista = new ArrayList<>();

		for (Flight f : fl) {
			TotalFlightDTO2 flightDto = new TotalFlightDTO2();
			flightDto.setAirportArrivalId(f.getAirportArrival());
			flightDto.setAirportDepartureId(f.getAirportDeparture());
			flightDto.setAirportArrival(airportRepo.findNameByIdAirport(f.getAirportArrival()));
			flightDto.setIdFlight(f.getIdFlight());
			flightDto.setAirportDeparture(airportRepo.findNameByIdAirport(f.getAirportDeparture()));
			flightDto.setTimeDeparture(f.getTimeDeparture());
			flightDto.setTimeArrival(f.getTimeArrival());
			flightDto.setCost(f.getCost());
			flightDto.setMax_capacity(f.getMaxCapacity());
			flightDto.setCompany(f.getCompany());
			lista.add(flightDto);
		}

		return lista;
	}
	public List<List<TotalFlightDTO>> getScali(FlightDTO dto){

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<List<TotalFlightDTO>> result = new ArrayList<>();
		List<TotalFlightDTO2> diretti = getByDate2(dto);
		List<Flight> scalo1 = flightRepo.findFlightsWithOneScalo(airportRepo.findNameByIdAirport(dto.getIdAirportDeparture(), dto.getIdAirportArrival()), );
		List<Flight> scalo2 = flightRepo.getDueScaliFlights(airportRepo.findNameByIdAirport(dto.getIdAirportArrival()), dto.getIdAirportDeparture(), dto.getIdAirportArrival(), LocalDate.parse(convertDateString(dto.getTimeDeparture()), formatter));
		List<TotalFlightDTO2> scalo2 = new ArrayList<>();
		return result;
		
	}
/*
	public List<List<TotalFlightDTO>> getScali(FlightDTO dto){
		List<List<TotalFlightDTO>> result = new ArrayList<>();
		List<TotalFlightDTO2> voli = getByDate2(dto);
		List<TotalFlightDTO2> voli1 = new ArrayList<>();
		List<TotalFlightDTO2> voli2 = new ArrayList<>();

		System.out.println("#");
		for(TotalFlightDTO2 volo: voli) {
			//se c'è un volo diretto lo metto nei risultati
			System.out.println(voli.size()+" "+volo.getAirportArrivalId()+" equals "+dto.getIdAirportArrival());
			if (volo.getAirportArrival().equals(airportRepo.findNameByIdAirport(dto.getIdAirportArrival()))){ 
				System.out.print("Yes:" + volo);
				List<TotalFlightDTO> tratta = new ArrayList<>();
				tratta.add(volo);
				result.add(tratta);
			}

			//altrimenti lo espando per controllare gli scali
			else if (!volo.getAirportArrival().equals(airportRepo.findNameByIdAirport(dto.getIdAirportDeparture()))){
				for(TotalFlightDTO2 v: getByDate2(new FlightDTO( volo.getAirportDepartureId(), volo.getAirportArrivalId(), volo.getTimeArrivalAsString()))) {//TODO fare flight DTO
					
					v.setChain(volo);
					System.out.print("Aggiunge voli1?: "+v);
					voli1.add(v);
				}
			}
		}
		System.out.println("##");
		for(TotalFlightDTO2 volo: voli1) {
			System.out.println("##"+voli.size()+" "+volo.getAirportArrivalId()+" equals "+dto.getIdAirportArrival());
			if (volo.getAirportArrival().equals(airportRepo.findNameByIdAirport(dto.getIdAirportArrival()))){ 
				List<TotalFlightDTO> tratta = new ArrayList<>();
				tratta.add(volo.getChain());
				tratta.add(volo);
				result.add(tratta);
			}
			else {
				for(TotalFlightDTO2 v: getByDate2(new FlightDTO( volo.getAirportDepartureId(), volo.getAirportArrivalId(), volo.getTimeArrivalAsString()))) {//TODO fare flight DTO
					v.setChain(volo);
					voli2.add(v);
				}
			}
		}

		System.out.println("###");
		for(TotalFlightDTO2 volo: voli2) {
			System.out.println("###"+voli.size()+" "+volo.getAirportArrivalId()+" equals "+dto.getIdAirportArrival());
			if (volo.getAirportArrival().equals(airportRepo.findNameByIdAirport(dto.getIdAirportArrival()))){ 
				List<TotalFlightDTO> tratta = new ArrayList<>();
				tratta.add(volo.getChain().getChain());
				tratta.add(volo.getChain());
				tratta.add(volo);
				result.add(tratta);
			}
		}
		return result;
		//[[volo],[volo2], [volo1, volo2], [volo1, volo2, volo3]]
	}
	*/
	public static String convertDateString(String dateString) {
	    try {
	        // Verifica se la stringa è già nel formato desiderato
	        LocalDate.parse(dateString);
	        return dateString.substring(0, 10);
	    } catch (DateTimeParseException e) {
	        // La stringa non è nel formato desiderato, quindi la converte
	        LocalDateTime localDateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);
	        return localDateTime.toLocalDate().toString();
	    }
	}
}
