import { Injectable } from '@angular/core';
import { HttpClient,  HttpHeaders} from '@angular/common/http';
import {Profiles} from "../model/profiles.model";
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class ProfileService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getAllProfiles(): Observable<Profiles[]> {
    return this.http.get<Profiles[]>(`${this.apiServerUrl}/profiles`);
  }
}
