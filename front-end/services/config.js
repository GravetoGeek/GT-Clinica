import axios from "axios";

export default axios.create({
    baseURL:'http://localhost:8080/api/',
    headers:{
        Accept:"application/json",
        "Content-type":"application/json",
        "Access-Control-Allow-Origin":"*",
    },
    withCredentials:false
})