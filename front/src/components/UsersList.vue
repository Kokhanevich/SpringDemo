<template >
    <el-table
            :data="tableData"
            border
            style="width: 100%">
        <el-table-column
                prop="login"
                label="Login"
                width="180">
        </el-table-column>
        <el-table-column
                prop="name"
                label="Name"
                width="180">
        </el-table-column>
        <el-table-column
                prop="userId"
                label="Delete">
            <template slot-scope="scope">
                <el-button
                        size="medium"
                        type="danger"
                        @click="removeUser(scope.row.userId)">Delete</el-button>
            </template>
        </el-table-column>
    </el-table>
</template>

<script>
    import {allUsers} from "../api/UserRepository";
    import {deleteUser} from "../api/delete";
    import axios from 'axios'

    export default {
        name: "UsersList",
        data() {
            return {
                tableData: []
            }
        },
        mounted() {
            allUsers().then(response => {
                this.tableData = response.data;
            })
        },
        methods: {
            removeUser: function (id) {
                // debugger;

                axios.delete(`http://localhost:8081/user/${id}`).then(response => {
                    console.log(response.data);
                })
            }
        }
    }
</script>


<style scoped>

</style>