<template>
    <div class="card my-3" style="cursor: pointer">
        <div class="card-body d-flex justify-content-between">
            <div class="c">
                <span>{{ company }}</span>
            </div>
            <div class="c">
                <span style="font-weight: bold;">{{ toHHMM(time_departure) }} - {{ toHHMM(time_arrival) }}</span>
            </div>
            <div class="c">
                <span :style="{ color: cost < 100 ? 'green' : cost > 200 ? 'red' : 'orange' }" class="fw-bold">€
                    {{ cost }}</span>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        company: {
            type: String,
            required: true
        },
        time_departure: {
            type: String,
            required: true
        },
        time_arrival: {
            type: String,
            required: true
        },
        cost: {
            type: String,
            required: true
        }
    },
    data() {
        return {
        }
    },
    methods: {
        toHHMM(d) {
            let date = new Date(d);
            let hours = date.getHours();
            let minutes = date.getMinutes();

            // Pad minutes with leading zeros if necessary
            minutes = minutes < 10 ? '0' + minutes : minutes;

            let timeString = hours + ":" + minutes;
            return timeString;
        }
    }
}
</script>

<style lang="scss" scoped>
.c {
    width: 110px;
}
</style>