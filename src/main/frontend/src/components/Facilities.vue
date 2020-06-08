<template>
    <div>
        <label>
            Dostępne obiekty: ({{facilities.length}})
        </label>
        <facilities-list :facilities="facilities"> </facilities-list>

    </div>
    
</template>
K
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
            // getAll() {
            //
            // }

        },
        mounted() {
            this.$http.get('facilities')
                .then(response => {
                    this.facilities.push(...response.body);

                })
                .catch(response => {
                    alert('Facility list not downloaded. Status: ' + response.status);
                });
        }
    }
</script>

<style scoped>

</style>