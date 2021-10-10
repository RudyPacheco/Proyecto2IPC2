export class usuarioLogin {
    private nombre: string;
    private contrasenia: string;



    constructor(nombre: string , contrasenia: string) {
        this.nombre=nombre;
        this.contrasenia=contrasenia;
    }

    public get nombreU() {
        return this.nombre;
    }

    public set nombreU(nombre : string) {
        this.nombre=nombre;
    }

    get contraseniaU() {
        return this.contrasenia;
    }

    set contraseniaU(contrasenia : string) {
        this.contrasenia=contrasenia;
    }



}