export class usuarioLoged {
    nombre: string;
    contrasenia: string;
    token: string;



    constructor(nombre: string , contrasenia: string,token: string) {
        this.nombre=nombre;
        this.contrasenia=contrasenia;
        this.token=token;
    }

    get nombreU() {
        return this.nombre;
    }

    set nombreU(nombre : string) {
        this.nombre=nombre;
    }

    get contraseniaU() {
        return this.contrasenia;
    }

    set contraseniaU(contrasenia : string) {
        this.contrasenia=contrasenia;
    }

    getAutentication() {
        return this.token;
    }



}