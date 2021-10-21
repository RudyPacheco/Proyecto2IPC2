export class usuarioLoged {
    nombre: string;
    apellido:string;
    usuario:string;
    informacion:string;
    etiquetasInteres:string[];
    //contrasenia: string;
    tipoCuenta: number;
    token: string;




    constructor(nombre: string,apellido:string,usuario:string,informacion:string,etiquetas:string[] ,tipocuenta:number,token: string) {
        this.nombre=nombre;
        this.apellido=apellido;
        this.usuario=usuario;
        this.informacion=informacion;
        this.etiquetasInteres=etiquetas;
       // this.contrasenia=contrasenia;
        this.tipoCuenta=tipocuenta;
        this.token=token;
    }

    get nombreU() {
        return this.nombre;
    }

    set nombreU(nombre : string) {
        this.nombre=nombre;
    }

    // get contraseniaU() {
    //     return this.contrasenia;
    // }

    // set contraseniaU(contrasenia : string) {
    //     this.contrasenia=contrasenia;
    // }

    get Token(){
        return this.token;
    }
    getAutentication() {
        return this.token;
    }



}