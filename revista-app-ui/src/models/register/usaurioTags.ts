export class UsuarioTag {

    nombreUsuario: string;
    etiquetas:string[];

    constructor( nombre:string,tags:string[]) {
        this.nombreUsuario=nombre;
        this.etiquetas=tags;
    }


}