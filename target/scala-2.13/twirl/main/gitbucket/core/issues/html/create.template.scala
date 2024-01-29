
package gitbucket.core.issues.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object create extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template10[List[String],List[gitbucket.core.model.Milestone],List[gitbucket.core.model.Priority],Option[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],List[gitbucket.core.model.CustomField],Boolean,String,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(collaborators: List[String],
  milestones: List[gitbucket.core.model.Milestone],
  priorities: List[gitbucket.core.model.Priority],
  defaultPriority: Option[gitbucket.core.model.Priority],
  labels: List[gitbucket.core.model.Label],
  customFields: List[gitbucket.core.model.CustomField],
  isManageable: Boolean,
  content: String,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*10.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*11.2*/gitbucket/*11.11*/.core.html.main(s"New Issue - ${repository.owner}/${repository.name}", Some(repository))/*11.99*/{_display_(Seq[Any](format.raw/*11.100*/("""
  """),_display_(/*12.4*/gitbucket/*12.13*/.core.html.menu("issues", repository)/*12.50*/{_display_(Seq[Any](format.raw/*12.51*/("""
    """),format.raw/*13.5*/("""<form action=""""),_display_(/*13.20*/helpers/*13.27*/.url(repository)),format.raw/*13.43*/("""/issues/new" method="POST" validate="true" class="form-group" autocomplete="off">
      <div class="row-fluid">
        <div class="col-md-9">
          <span id="error-title" class="error"></span>
          <input type="text" id="issue-title" name="title" class="form-control" value="" placeholder="Title" style="margin-bottom: 6px;" autofocus/>
          """),_display_(/*18.12*/gitbucket/*18.21*/.core.helper.html.preview(
            repository         = repository,
            content            = content,
            enableWikiLink     = false,
            enableRefsLink     = true,
            enableLineBreaks   = true,
            enableTaskList     = true,
            hasWritePermission = isManageable,
            completionContext  = "issues",
            style              = "height: 200px; max-height: 500px;",
            elastic            = true
          )),format.raw/*29.12*/("""
          """),format.raw/*30.11*/("""<div class="align-right">
            <input type="submit" class="btn btn-success" value="Submit new issue" onclick="javascript:return checkCustomFieldErrors();"/>
          </div>
        </div>
        <div class="col-md-3">
          """),_display_(/*35.12*/gitbucket/*35.21*/.core.issues.html.issueinfo(
            issue = None,
            comments = Nil,
            issueLabels = Nil,
            issueAssignees = Nil,
            collaborators = collaborators,
            milestones = milestones.map(x => (x, 0, 0)),
            priorities= priorities,
            defaultPriority = defaultPriority,
            labels = labels,
            customFields = customFields.map((_, None)),
            isManageable = isManageable,
            repository = repository
          )),format.raw/*48.12*/("""
        """),format.raw/*49.9*/("""</div>
      </div>
    </form>
    <script>
      function checkCustomFieldErrors() """),format.raw/*53.41*/("""{"""),format.raw/*53.42*/("""
        """),format.raw/*54.9*/("""let error = false;
        $('.custom-field-error').each(function(i, e) """),format.raw/*55.54*/("""{"""),format.raw/*55.55*/("""
          """),format.raw/*56.11*/("""if ($(e).text() != '') """),format.raw/*56.34*/("""{"""),format.raw/*56.35*/("""
            """),format.raw/*57.13*/("""error = true;
          """),format.raw/*58.11*/("""}"""),format.raw/*58.12*/("""
        """),format.raw/*59.9*/("""}"""),format.raw/*59.10*/(""");
        return !error;
      """),format.raw/*61.7*/("""}"""),format.raw/*61.8*/("""
    """),format.raw/*62.5*/("""</script>
  """)))}),format.raw/*63.4*/("""
""")))}),format.raw/*64.2*/("""
"""))
      }
    }
  }

  def render(collaborators:List[String],milestones:List[gitbucket.core.model.Milestone],priorities:List[gitbucket.core.model.Priority],defaultPriority:Option[gitbucket.core.model.Priority],labels:List[gitbucket.core.model.Label],customFields:List[gitbucket.core.model.CustomField],isManageable:Boolean,content:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(collaborators,milestones,priorities,defaultPriority,labels,customFields,isManageable,content,repository)(context)

  def f:((List[String],List[gitbucket.core.model.Milestone],List[gitbucket.core.model.Priority],Option[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],List[gitbucket.core.model.CustomField],Boolean,String,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (collaborators,milestones,priorities,defaultPriority,labels,customFields,isManageable,content,repository) => (context) => apply(collaborators,milestones,priorities,defaultPriority,labels,customFields,isManageable,content,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/create.scala.html
                  HASH: e7dc0b94d3698c6236d41e5045cf0d0e5d3043dc
                  MATRIX: 878->1|1410->461|1474->497|1492->506|1589->594|1629->595|1659->599|1677->608|1723->645|1762->646|1794->651|1836->666|1852->673|1889->689|2274->1047|2292->1056|2793->1536|2832->1547|3097->1785|3115->1794|3640->2298|3676->2307|3789->2392|3818->2393|3854->2402|3954->2474|3983->2475|4022->2486|4073->2509|4102->2510|4143->2523|4195->2547|4224->2548|4260->2557|4289->2558|4348->2590|4376->2591|4408->2596|4451->2609|4483->2611
                  LINES: 14->1|25->10|28->11|28->11|28->11|28->11|29->12|29->12|29->12|29->12|30->13|30->13|30->13|30->13|35->18|35->18|46->29|47->30|52->35|52->35|65->48|66->49|70->53|70->53|71->54|72->55|72->55|73->56|73->56|73->56|74->57|75->58|75->58|76->59|76->59|78->61|78->61|79->62|80->63|81->64
                  -- GENERATED --
              */
          