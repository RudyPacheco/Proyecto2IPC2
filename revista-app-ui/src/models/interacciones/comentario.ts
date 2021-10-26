export class comentario {
    
    
    nombreUsuario:string;
    codigoRevista:number;
    comentario:string;
    fechaComentario:string;
    
    
    constructor(nombre:string,codigo:number,comentario:string,fecha:string) {
        this.nombreUsuario=nombre;
        this.codigoRevista=codigo;
        this.comentario=comentario;
        this.fechaComentario=fecha;
    }
}