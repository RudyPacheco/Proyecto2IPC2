import { usuarioLoged } from "../auth/usuarioLoged";

export class usaurioActualizacion {
    usuarioAntiguo:usuarioLoged;
    nombre: string;
    apellido:string;
    informacion:string;
    etiquetasInteres:string[];
   
  
    
    
    constructor(usuarioN:usuarioLoged,nombre:string,apellido:string,informacion:string,tags:string[]) {
        this.usuarioAntiguo=usuarioN;
        this.nombre=nombre;
        this.apellido=apellido;
        this.informacion=informacion;
        this.etiquetasInteres=tags;
        
    }
}