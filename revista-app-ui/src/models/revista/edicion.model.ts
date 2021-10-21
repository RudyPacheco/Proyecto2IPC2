export class edicionModel {
    codigo:number;
    codigoRevista:number;
    direccion:string;
    fechaCreacion:string;


    constructor(codigo:number,codigoRevista:number,direccion:string,fechaCreacion:string) {
        this.codigo=codigo;
        this.codigoRevista=codigoRevista;
        this.direccion=direccion;
        this.fechaCreacion=fechaCreacion;
    }
}