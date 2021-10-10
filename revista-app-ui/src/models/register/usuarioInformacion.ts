export class UsuarioInfo {

    private nombreUsuario:string;
    private informacionUsuario:string;

    constructor(nombre:string,info:string) {
        this.nombreUsuario=nombre;
        this.informacionUsuario=info;
    
    }

    public getNombre(){
        return this.nombreUsuario;
    }

    public getInfo(){
        return this.informacionUsuario;
    }

    public setNombre(nombre:string){
        this.nombreUsuario=nombre;
    }

    public setInfo(info:string){
        this.informacionUsuario=info;
    }

}