import { revista } from "src/models/revista/revista.model";


export class suscripcion {

    revista:revista;
    nombreUsuario:string;
    fechaSuscripcion:string;
    tipoSuscripion:number


    constructor(private revistaR:revista,private nombre:string,private fecha:string,private tipo:number) {
        this.revista=revistaR;
        this.nombreUsuario=nombre;
        this.fechaSuscripcion=fecha;
        this.tipoSuscripion=tipo;
    }
}