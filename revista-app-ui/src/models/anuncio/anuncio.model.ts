export class anuncioModel {

    codigo:number;
    anunciante:string;
    canitdadDias:number;
    fechaPublicacion:string;
    etiquetas: string[];
    textoAnuncio:string;
    imagen:string;
    contentType:string;
    video:string;
    precio:number;
    tipoAnuncio:number;

    constructor(codigo:number,anunciante:string,dias:number,fecha:string,tags:string[],texto:string,imagen:string,video:string,tipo:number,precio:number,contentT:string) {
        this.codigo=codigo;
        this.anunciante=anunciante;
        this.canitdadDias=dias;
        this.fechaPublicacion=fecha;
        this.etiquetas=tags;
        this.textoAnuncio=texto;
        this.imagen=imagen;
        this.contentType=contentT;
        this.video=video;
        this.tipoAnuncio=tipo;
        this.precio=precio;
    }



}