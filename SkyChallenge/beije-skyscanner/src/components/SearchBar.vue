<template>
    <div class="container-fluid">
        <div class="container">
            <div class="row">
                <div class="col-12 text-start pb-2">
                    <h2>Quickly scan all your favourite travel sites</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-3">
                    <select class="form-select" aria-label="Default select example" v-model="id_airport_departure">
                        <option value="" disabled>From</option>
                        <option v-for="a in airports" :key="a.id" :value="a.id_airport">{{ a.name }}</option>
                    </select>
                </div>
                <div class="col-3">
                    <select class="form-select" aria-label="Default select example" v-model="id_airport_arrival">
                        <option value="" disabled>To</option>
                        <option v-for="a in airports" :key="a.id" :value="a.id_airport">{{ a.name }}</option>
                    </select>
                </div>
                <div class="col-2">
                    <div class="form-floating">
                        <input type="date" class="form-control" id="floatingInputGroup1" placeholder="Depart"
                            v-model="timeDeparture">
                        <label for="floatingInputGroup1" style="font-size: small;">Depart</label>
                    </div>
                    
                </div>
                <div class="col-2">
                    <div class="form-floating">
                        <input type="date" class="form-control" id="floatingInputGroup1" placeholder="Return"
                            v-model="returnDate" :disabled="onlyDeparture">
                        <label for="floatingInputGroup1" style="font-size: small;">Return</label>
                    </div>
                </div>
                <div class="col-2">
                    <button class="btn btn-primary" @click="search">Search</button>
                    <div>
                        <input type="checkbox" id="a" v-model="onlyDeparture">
                        <label for="a" class="text-white fw-bold px-1">Solo andata</label>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>


<script>
export default {
    name: "SearchBar",
    props: ['airports'],
    data() {
        return {
            id_airport_departure: "",
            id_airport_arrival: "",
            timeDeparture: "",
            returnDate: null,
            onlyDeparture: false
        }
    },
    methods: {
        search() {
            console.log(this.id_airport_departure)
            let body = {
                id_airport_departure: this.id_airport_departure,
                id_airport_arrival: this.id_airport_arrival,
                timeDeparture: this.timeDeparture,
                returnDate: this.returnDate
            }
            console.log(body)
            this.$emit('search', body)
        }
    }
}
</script>

<style lang="scss">
.form-floating {
    height: 72px;
}

.form-select {
    height: 58px;
}

.btn-primary {
    height: 58px;
    width: 100%;
}
</style>