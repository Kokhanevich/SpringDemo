import axios from 'axios'
export function deleteUser(id) {
    return axios.delete(`http://localhost:8081/user/{id}`).then(response => {
        this.result.splice(id, 1)
    });

}