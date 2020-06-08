<template>
    <div>
        <label>Zaloguj się nazwą użytkownika</label>
        <input type="email" v-model="login">
        <button @click="logIn()">{{buttonDisplayed}}</button>
    </div>
    
</template>

<script>
    export default {
        props: ['buttonLabel'],
        data() {
            return {
                login: ''
            }
        },
        methods: {
            logIn() {
                this.$emit('logMeIn', this.login);
            }
        },
        computed: {
            buttonDisplayed() {
                return this.buttonLabel || 'Zaloguj się';
            }
        },

    }
</script>
