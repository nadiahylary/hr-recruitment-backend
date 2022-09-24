import { Component, OnInit } from '@angular/core';
import { Profiles } from 'src/app/model/profiles.model';
import { HttpErrorResponse } from '@angular/common/http';
import { ProfileService } from 'src/app/service/profiles.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ListProfilesComponent implements OnInit {
  public profiles: Profiles[] = [];

  constructor(private router: Router, private profilesService: ProfileService) { }

  ngOnInit(): void {
    this.getProfiles();
  }
  public getProfiles(): void {
    this.profilesService.getAllProfiles().subscribe(
      (response: Profiles[]) => {
        this.profiles = response;
        console.log(this.profiles);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  /*
  getProfiles() {
    this.profilesService.getAllProfiles().then(
      profiles => {
        this.profiles = profiles;
      },
      err => {
        console.log(err);
      }
    );
  }*/
  public searchProfiles(key: string): void {
    console.log(key);
    const results: Profiles[] = [];
    for (const profile of this.profiles) {
      if (
        profile.category.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || profile.linkedin.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || profile.profile_picture.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || profile.description.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || profile.Experience.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || profile.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || profile.position.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || profile.location.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || profile.skills.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || profile.clean_skills.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(profile);
      }
    }
    this.profiles = results;
    if (results.length === 0 || !key) {
      this.getProfiles();
    }
  }

}

