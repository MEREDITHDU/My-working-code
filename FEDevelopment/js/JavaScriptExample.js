
	'use strict';

	function ageInDays() {
	let BirthYear=prompt('Which year were you born');
	let AgeInDays=(2021-BirthYear)*365;
	let h1=document.createElement('h1');
	let Answer=document.createTextNode('You are'+AgeInDays+'Days old');
	h1.setAttribute('id','ageInDays');
	h1.appendChild(Answer);
	document.getElementById('id').appendChild('h1');
}
// ageInDays();

