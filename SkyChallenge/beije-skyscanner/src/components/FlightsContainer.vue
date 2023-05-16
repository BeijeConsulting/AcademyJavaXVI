<template>
    <div class="container">
        <div class="row justify-content-center pt-5" v-if="flights.outward_flights.length > 0">
            <div class="col text-start" style="padding-left: 140px;">
                <h1>Best departing options</h1>
            </div>
        </div>
        <div class="row justify-content-center pb-5" v-if="flights.outward_flights.length > 0">
            <div class="col d-flex justify-content-center flex-column align-items-center">
                <FlightCard style="width: 80%;" v-for="(f, i) in flights.outward_flights" :key="i" :company="f.company" :time_departure="f.time_departure" :time_arrival="f.time_arrival" :cost="f.cost"/>
            </div>
        </div>
        <div v-else>
            <h1>No outbound flights</h1>
        </div>
        <div class="row justify-content-center pt-5" v-if="flights.return_flights.length > 0">
            <div class="col text-start" style="padding-left: 140px;">
                <h1>Best returning options</h1>
            </div>
        </div>
        <div class="row justify-content-center pb-5" v-if="flights.return_flights.length > 0">
            <div class="col d-flex justify-content-center flex-column align-items-center">
                <FlightCard style="width: 80%;" v-for="(f, i) in flights.return_flights" :key="i" :company="f.company" :time_departure="f.time_departure" :time_arrival="f.time_arrival" :cost="f.cost"/>
            </div>
        </div>
        <div v-else>
            <h1>No return flights</h1>
        </div>
    </div>
</template>

<script>
import FlightCard from './FlightCard.vue';

export default {
    components: {
        FlightCard
    },
    props: ['flights'],
}
</script>