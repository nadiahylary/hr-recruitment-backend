import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListProfilesComponent} from "./linkedinprofiles/list-profiles/profiles.component";

const routes: Routes = [{path: 'api/profiles', component: ListProfilesComponent},];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
