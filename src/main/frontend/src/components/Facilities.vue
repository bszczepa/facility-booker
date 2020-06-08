<template>
    <div>
        <label>
            Dostępne obiekty: ({{facilities.length}})
        </label>
        <facilities-list :facilities="facilities"> </facilities-list>

    </div>
    
</template>

<script>
    import FacilitiesList from "./FacilitiesList";

    export default {
        props: ['username'],
        components: {FacilitiesList},
        data() {
            return {
                facilities: []
            }
        },
        methods: {
            getAll() {

            }

        }
    }
</script>

<style scoped>

</style>