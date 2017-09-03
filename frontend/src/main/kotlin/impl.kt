import kotlin.browser.window

impl fun log(message: Message) {
    window.alert(message.text)
}
