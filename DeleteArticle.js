async function deleteAllAnswers() {
const root = document.getElementById('Profile-answers')
/* The Document method querySelectorAll() returns a static (not live) NodeList representing 
* a list of the document's elements that match the specified group of selectors.
* Syntax: elementList = parentNode.querySelectorAll(selectors);
* e.g: const matches = document.querySelectorAll("p");
*/
const list = [...root.querySelectorAll('.AnswerItem')].map(e =>
window.fetch(
`https://www.zhihu.com/api/v4/answers/${e.getAttribute('name')}`,
{
  method: 'DELETE',
}
)
)
//syntax: Promise.all(iterable);
//The Promise.all() method takes an iterable of promises as an input, 
//and returns a single Promise that resolves to an array of the results of the input promises. 
await Promise.all(list)
window.location.reload()
}

// Note: fetch Syntax:
//fetch('http://example.com/movies.json')
//  .then(response => response.json())
//  .then(data => console.log(data));
