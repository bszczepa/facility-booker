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
                <button>Pokaż dostępne aktywności</button>
            </td>
        </tr>
        </tbody>
    </table>


</template>

<script>
    export default {
        props:['facilities'],
    }
</script>

<style scoped>

</style>