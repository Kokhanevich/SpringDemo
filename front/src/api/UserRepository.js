import axios from 'axios'
 export function allUsers(limit) {
    if (limit === undefined) {
        limit = 25
    }
    return axios.get(`/api/user/all?limit=${limit}`).then((response) => {
        console.log(response.data);
        return response;
    })

}