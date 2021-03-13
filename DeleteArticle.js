async function deleteAllAnswers() {
const root = document.getElementById('Profile-answers')
const list = [...root.querySelectorAll('.AnswerItem')].map(e =>
window.fetch(
`https://www.zhihu.com/api/v4/answers/${e.getAttribute('name')}`,
{
  method: 'DELETE',
}
)
)
await Promise.all(list)
window.location.reload()
}
