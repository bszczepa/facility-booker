<template xmlns:class="http://www.w3.org/1999/xhtml">
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
                <div v-for="activity in facility.activities" :key="facility.activities.name">
                    <div class:="float-right">
                        {{activity.name}}
                        <button class="button-outline" @click=""> Rezerwuj </button>
                    </div>

                </div>
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
            },
            reserve(activity){



            }

        },
    }
</script>

<style scoped>

</style>