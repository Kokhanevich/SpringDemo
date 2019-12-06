import axios from 'axios'
export function registration(login, password, name) {
    debugger;
    return axios.post(`http://localhost:8081/api/auth/signup`, {
        name: name,
        login: login,
        password: password
    }).then((response) => {
        console.log(response.data);
        return response;
    })
}