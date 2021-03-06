import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.attachment.CreateAttachmentParamsBean

def attachmentManager = ComponentAccessor.getAttachmentManager()
def user = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser()

String pathToFile = "/var/atlassian/jira/"
String fileName   = "test.txt"
String pathAndFile = pathToFile+fileName

def bean = new CreateAttachmentParamsBean.Builder()
    .file(new File(pathAndFile))
    .filename(fileName)
    .contentType("text/txt")
    .author(user)
    .issue(issue)
    .copySourceFile(true)//you must do this otherwise it deletes the source file from the file system
    .build()
attachmentManager.createAttachment(bean)
