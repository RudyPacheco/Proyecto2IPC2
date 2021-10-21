export class revista {
    
    codigo:number;
    nombreRevista: string;
    categoria: string;
    precioRevista: number;
    descripcion: string;
    fechaCreacion:string;
    editor:string;
    interaccion:boolean;
    etiquetas: string[];

    constructor(codigo:number,nombre:string,precio:number,descripcion:string,categoria: string,tags: string[],editor:string,fecha:string,interaccion:boolean) {
        this.codigo=codigo;
        this.nombreRevista=nombre;
        this.precioRevista=precio;
        this.descripcion=descripcion;
        this.categoria=categoria;
        this.etiquetas=tags;
        this.editor=editor;
        this.fechaCreacion=fecha;
        this.interaccion=interaccion;
       
    }
}