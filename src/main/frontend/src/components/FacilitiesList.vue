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
                        <div v-for="reservation in activity.reservations" :key="activity.reservations.id">
                            {{reservation.date}}
                            {{reservation.price}}
                            <button v-if="reserved == false"class="button-outline" @click="reserve(reservation,username)"> Rezerwuj </button>
                            {{reservation.username}}

                        </div>

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
        props:['facilities','username'],
        data() {
            return {
                activitiesFlag: false,
                showingActivities: false,
                reserved: false,
                username: ''
            }

        },

        methods: {
            toggleActivities() {
                this.activitiesFlag = !this.activitiesFlag;
                this.showingActivites =true;
            },
            toggleReservedState(){
                this.reserved = true;
            },
            reserve(reservation, newName) {
                reservation.username = newName;
                this.$http.put('reservation/' + reservation.id, reservation)
                    .then(response => {
                        // this.reservation.name = username;
                    })
                    .catch(response => {
                        alert('Reservation not saved. Status: ' + response.status);
                    });

                this.toggleReservedState()
            },

        },
    }
</script>

<style scoped>

</style>