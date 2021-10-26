export class permisosModel {

    codigoRevista:number;
    interaccion:boolean;
    bloqueo_sub:boolean;


    constructor(codigo:number,intera:boolean,sub:boolean) {
        this.codigoRevista=codigo;
        this.interaccion=intera;
        this.bloqueo_sub=sub;
    }
}