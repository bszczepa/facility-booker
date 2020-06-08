<template>
    <div>
        <activities-list :activities="activities"></activities-list>
    </div>
    
</template>

<script>
    import ActivitiesList from "./ActivitiesList";
    export default {
        data() {
            return {
               activities: [],
            }
        },
        components: {ActivitiesList},
        props:['something'],
        mounted() {
            {
                this.$http.get('activities')
                    .then(response => {
                        this.activities.push(...response.body);

                    })
                    .catch(response => {
                        alert('Activity list not downloaded. Status: ' + response.status);
                    });
            }
        }

    }
</script>

<style scoped>

</style>