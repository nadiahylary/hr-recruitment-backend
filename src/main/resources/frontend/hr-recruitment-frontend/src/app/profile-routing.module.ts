import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListProfilesComponent } from './linkedinprofiles/list-profiles/profiles.component';
const routes: Routes = [
  {path: 'api/profiles', component: ListProfilesComponent},
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfileRoutingModule { }
