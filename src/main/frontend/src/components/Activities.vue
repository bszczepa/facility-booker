<template>
    <div>
        <activities-list :activities="activities"
                         :facility="facility"></activities-list>
    </div>
    
</template>

<script>
    import ActivitiesList from "./ActivitiesList";
    export default {
        data() {
            return {
               activities: [],
                facility:[]
            }
        },
        components: {ActivitiesList},
        props:['facility'],

        // mounted() {
        //     {
        //         this.$http.get('activities')
        //             .then(response => {
        //                 this.activities.push(...response.body);
        //
        //             })
        //             .catch(response => {
        //                 alert('Activity list not downloaded. Status: ' + response.status);
        //             });
        //     }
        // }

    }
</script>

<style scoped>

</style>