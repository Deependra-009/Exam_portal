import { HttpClient } from '@angular/common/http';
import { Token } from '@angular/compiler';
import { Injectable } from '@angular/core';
import baseurl from './URL';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor(
    private http:HttpClient
  ) { }

  public generateToken(user:any){
    return this.http.post(`${baseurl}/generate-token`,user);
  }

  public getCurrentUser(){
    return this.http.get(`${baseurl}/currentuser`);
  }

  public loginuser(token:string){
    localStorage.setItem("token",token);
    return true;
  }

  public isLoggedIn(){
    let token=localStorage.getItem("token");
    if(token==undefined || token=='' || token==null){
      return false;
    }
    return true;
  }

  public logggedout(){
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    return true;
  }

  public getToken(){
    return localStorage.getItem("token");
  }

  public setUser(user:any){
    localStorage.setItem("user",JSON.stringify(user));
  }

  public getUser(){
    let user=localStorage.getItem("user");
    if(user!=null){
      return JSON.parse(user);
    }
    else{
      this.logggedout();
      return null;
    }
  }

  public getUserRole(){
    let user=this.getUser();
    return user.authorities[0].authority;
  }

}
