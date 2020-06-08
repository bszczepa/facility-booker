<template>
  <div id="app">
      <h1> Witaj w systemie wynajmowania obiektów sportowych!</h1>
      <div v-if="loggedInUser == ''">
          <login-box @logMeIn="logMeIn($event)"></login-box>
      </div>
      <div v-else>
          <div>
              <logout-box @logoutEvent="logMeOut($event)" :username="loggedInUser" ></logout-box>
          </div>
      </div>
      <div v-show="loggedInUser != ''">
          <facilities :username="loggedInUser"></facilities>
      </div>


  </div>

</template>

<script>

    import "milligram";
    import LoginBox from "./components/LoginBox";
    import LogoutBox from "./components/LogoutBox";
    import FacilitiesList from "./components/FacilitiesList";
    import Facilities from "./components/Facilities";

    export default {

        components: {FacilitiesList, LogoutBox, LoginBox, Facilities},

        data() {
            return {
                loggedInUser:'',
            };
        },

        methods: {
            logMeIn(username) {
                this.loggedInUser = username;
            },
            logMeOut() {
                this.loggedInUser = '';
            }

        },

    }


</script>

<style>

</style>
