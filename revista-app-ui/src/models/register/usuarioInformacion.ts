export class UsuarioInfo {

    private nombreUsuario:string;
    private informacionUsuario:string;
            etiquetasUsuario:String[];

    constructor(nombre:string,info:string,tags:string[]) {
        this.nombreUsuario=nombre;
        this.informacionUsuario=info;
        this.etiquetasUsuario=tags;
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