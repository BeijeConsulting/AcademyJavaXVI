<template>
    <div class="card mb-5" style="width: 18rem;">
        <img :src="imgSrc" class="card-img-top" alt="Card image" style="max-height: 161px;">
        <div class="card-body">
            <h5 class="card-title">{{ title }}</h5>
        </div>
    </div>
</template>
  
<script>
export default {
    props: {
        title: {
            type: String,
            required: true
        },
        imgSrc: {
            type: String,
            required: true
        }
    }
}
</script>

<style lang="scss" scoped>
@import '../assets/variable.scss';
.card-title {
    font-weight: bold;
    color: $primary-color;
}
.card{
    cursor: pointer;
}
</style>