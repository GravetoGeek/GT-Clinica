import axios from "axios";
export default {
    listar(){
        return  axios.get('/pacientes')
    },



}