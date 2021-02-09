export default {
    listar(){
        return  this.$http.get('/medicos')
    }
}