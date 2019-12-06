<template>
    <div>
        <h4>Register</h4>
        <form>
            <label for="name">Name</label>
            <div>
                <input id="name" type="text" v-model="name" required >
            </div>
            <label for="login" >Login</label>
            <div>
                <input id="login" type="text" v-model="login" required>
            </div>
            <label for="password">Password</label>
            <div>
                <input id="password" type="password" v-model="password" required>
            </div>
            <label for="password-confirm">Confirm Password</label>
            <div>
                <input id="password-confirm" type="password" v-model="password_confirmation" required>
            </div>

            <div>
                <button type="submit" @click="handleSubmit">
                    Register
                </button>
            </div>
        </form>
    </div>
</template>

<script>
    import {registration} from "../api/registration";

    export default {
        props : ["nextUrl"],
        data(){
            return {
                name : "",
                login : "",
                password : "",
                password_confirmation : ""
            }
        },
        methods : {
            handleSubmit(e) {
                e.preventDefault()
                if (this.password === this.password_confirmation && this.password.length > 0)
                {
                    registration(this.login, this.password, this.name).then(response => {
                        console.log(response.data);
                    });
                } else {
                    this.password = ""
                    this.passwordConfirm = ""
                    return alert("Passwords do not match")
                }
            }
        }
    }
</script>

<style scoped>

</style>