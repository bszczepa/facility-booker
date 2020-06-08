<template>
    <div>
        <label>
            <h5>
                Witaj {{username}}!
            </h5>
        </label>
        <button @click="logOut()">Wyloguj</button>
    </div>
</template>

<script>
    export default {
        props: ['username'],
        methods: {
            logOut() {
                this.$emit('logoutEvent',this.username)
            }
        },
    }
</script>

<style scoped>

</style>