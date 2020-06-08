<template>
    <table v-if="activities.length > 0">
        <thead>
        <tr>
            <th>Nazwa aktywności</th>
            <th></th>
            <th>Rezerwuj!</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="activity in activities" :key="activity.name">
            <td>{{activity.name}}</td>
            <td></td>
            <td>
                <button>Rezerwuj</button>
            </td>
        </tr>
        </tbody>
    </table>
</template>

<script>
    export default {
        props: ['activities'],

    }
</script>

<style scoped>

</style>