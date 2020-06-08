<template>
    <table v-if="facilities.length > 0">
        <thead>
        <tr>
            <th>Nazwa obiektu</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="facility in facilities" :key="facility.name">
            <td>{{facility.name}}</td>
            <td></td>
            <td>
                <button @click="toggleActivities()">Pokaż aktywności</button>
                <activities v-if="activitiesFlag" :facility="facilities"> </activities>
            </td>
        </tr>
        </tbody>
    </table>


</template>

<script>
    import Activities from "./Activities";
    import ActivitiesList from "./ActivitiesList";
    export default {
        components: {ActivitiesList, Activities},
        props:['facilities'],
        data() {
            return {
                activitiesFlag: false,
                showingActivities: false,
            }

        },

        methods: {
            toggleActivities() {
                this.activitiesFlag = !this.activitiesFlag;
                this.showingActivites =true;
            }
        },
    }
</script>

<style scoped>

</style>