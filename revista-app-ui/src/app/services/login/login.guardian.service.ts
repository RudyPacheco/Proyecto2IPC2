import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { loginServices } from "./login.services";
@Injectable()

export class LoginGuardian implements CanActivate {
  
    constructor(private loginService: loginServices, private router:Router) {
        
    }
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
        if (this.loginService.getToken()) {
            return true;
        }else{
            this.router.navigate(['login']);
            return false;
        }
    }

}