<template>
  <div class="d-flex flex-column justify-content-between h-100">
    <div>
      <NavBar />
      <SearchBar :airports="airports" @search="getFlights"/>
      <CardContainer v-if="showCard"/>
      <FlightsContainer :flights="flights" v-else-if="test"/>
    </div>
    <FooterComponent />
  </div>
</template>

<script>
// @ is an alias to /src
import NavBar from '@/components/NavBar.vue';
import SearchBar from '@/components/SearchBar.vue'
import FooterComponent from '@/components/FooterComponent.vue'
import CardContainer from '@/components/CardContainer.vue';
import FlightsContainer from '@/components/FlightsContainer.vue';

export default {
  name: 'HomeView',
  components: {
    NavBar, SearchBar, FooterComponent, CardContainer, FlightsContainer
  },
  computed: {
    test() {
      return this.flights
    }
  },
  data() {
    return {
      airports: [],
      flights: false,
      showCard: true
    }
  },
  async created() {
    this.airports = await this.fetchAirports();
    // console.log("Siamo qui",this.airports)
  },
  methods: {
    async fetchAirports() {
       return fetch('http://localhost:8080/airports')
        .then(response => {
          if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
          }
          return response.json();
        })
        .then(data => {
          // console.log(data)
          return data;
        })
        .catch(error => {
          console.log('There has been a problem with your fetch operation: ', error.message);
        });
    },
    async getFlights(body) {
      this.showCard = false;
      await this.fetchFlights(body);
    },
    async fetchFlights(bodyData) {
      try {
        const response = await fetch('http://localhost:8080/flightsByDate', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(bodyData),
        });
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        console.log(data);
        this.flights = data;
        return data;
      } catch (error) {
        console.error('There has been a problem with your fetch operation: ', error.message);
        return null;
      }
    }
  }
}
</script>
