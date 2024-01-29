
package gitbucket.core.pulls.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object menu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template11[String,gitbucket.core.model.Issue,gitbucket.core.model.PullRequest,Seq[gitbucket.core.util.JGitUtil.CommitInfo],Seq[gitbucket.core.model.Comment],Int,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,Map[String, String],Html,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String,
  issue: gitbucket.core.model.Issue,
  pullreq: gitbucket.core.model.PullRequest,
  commits: Seq[gitbucket.core.util.JGitUtil.CommitInfo],
  comments: Seq[gitbucket.core.model.Comment],
  changedFileSize: Int,
  isManageable: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  flash: Map[String, String] = Map.empty)(body: => Html)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*10.2*/import gitbucket.core.view.helpers
/*11.2*/import gitbucket.core.model.Comment
/*12.2*/import gitbucket.core.model.CommitComments
/*13.2*/import gitbucket.core.model.IssueComment

def /*125.2*/countConversation/*125.19*/(comments: Seq[Comment]) = {{
  comments.collect {
    case c: CommitComments => c.comments.size
    case c: IssueComment if c.action.endsWith("comment") => 1
  }.sum
}};
Seq[Any](_display_(/*14.2*/gitbucket/*14.11*/.core.html.main(s"${issue.title} - Pull request #${issue.issueId} - ${repository.owner}/${repository.name}", Some(repository))/*14.137*/ {_display_(Seq[Any](format.raw/*14.139*/("""
  """),_display_(/*15.4*/gitbucket/*15.13*/.core.html.menu("pulls", repository)/*15.49*/ {_display_(Seq[Any](format.raw/*15.51*/("""
      """),format.raw/*16.7*/("""<div>
        <div class="show-title pull-right">
          """),_display_(if(isManageable || context.loginAccount.map(_.userName == issue.openedUserName).getOrElse(false))/*18.109*/ {_display_(Seq[Any](format.raw/*18.111*/("""
            """),format.raw/*19.13*/("""<a class="btn btn-default" href="#" id="edit">Edit</a>
          """)))} else {null} ),format.raw/*20.12*/("""
          """),_display_(if(context.loginAccount.isDefined)/*21.46*/ {_display_(Seq[Any](format.raw/*21.48*/("""
            """),format.raw/*22.13*/("""<a class="btn btn-success" href=""""),_display_(/*22.47*/helpers/*22.54*/.url(repository)),format.raw/*22.70*/("""/compare">New pull request</a>
          """)))} else {null} ),format.raw/*23.12*/("""
        """),format.raw/*24.9*/("""</div>
        <div class="edit-title pull-right" style="display: none;">
          <a class="btn btn-success" href="#" id="update">Save</a>  <a class="btn btn-default" href="#" id="cancel">
          Cancel</a>
        </div>
        <h1 class="body-title">
          <span class="show-title">
            <span id="show-title">"""),_display_(/*31.36*/issue/*31.41*/.title),format.raw/*31.47*/("""</span>
            <span class="muted">#"""),_display_(/*32.35*/issue/*32.40*/.issueId),format.raw/*32.48*/("""</span>
          </span>
          <span class="edit-title" style="display: none;">
            <span id="error-edit-title" class="error"></span>
            <input type="text" class="form-control" style="width: 700px;" id="edit-title" value=""""),_display_(/*36.99*/issue/*36.104*/.title),format.raw/*36.110*/(""""/>
          </span>
        </h1>
      </div>
      <div style="margin-bottom: 15px">
      """),_display_(if(issue.closed)/*41.24*/ {_display_(Seq[Any](format.raw/*41.26*/("""
        """),_display_(/*42.10*/comments/*42.18*/.flatMap{/*42.28*/{
          case comment: IssueComment => Some(comment)
          case _ => None
        }}/*45.10*/.find(_.action == "merge").map/*45.40*/ { comment =>_display_(Seq[Any](format.raw/*45.53*/("""
        """),format.raw/*46.9*/("""<span class="label label-info issue-status">Merged</span>
        <span class="muted">
          """),_display_(/*48.12*/helpers/*48.19*/.user(comment.commentedUserName, styleClass = "username strong")),format.raw/*48.83*/("""
          """),format.raw/*49.11*/("""merged """),_display_(/*49.19*/commits/*49.26*/.size),format.raw/*49.31*/(""" """),_display_(/*49.33*/helpers/*49.40*/.plural(commits.size, "commit")),format.raw/*49.71*/("""
          """),format.raw/*50.11*/("""into <code><a href=""""),_display_(/*50.32*/helpers/*50.39*/.basePRBranchUrl(pullreq)),format.raw/*50.64*/("""">"""),_display_(/*50.67*/pullreq/*50.74*/.userName),format.raw/*50.83*/(""":"""),_display_(/*50.85*/pullreq/*50.92*/.branch),format.raw/*50.99*/("""</a></code>
          from <code><a href=""""),_display_(/*51.32*/helpers/*51.39*/.requestPRBranchUrl(pullreq)),format.raw/*51.67*/("""">"""),_display_(/*51.70*/pullreq/*51.77*/.requestUserName),format.raw/*51.93*/(""":"""),_display_(/*51.95*/pullreq/*51.102*/.requestBranch),format.raw/*51.116*/("""</a></code>
          """),_display_(/*52.12*/gitbucket/*52.21*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*52.74*/("""
        """),format.raw/*53.9*/("""</span>
        """)))}/*54.10*/.getOrElse/*54.20*/ {_display_(Seq[Any](format.raw/*54.22*/("""
          """),format.raw/*55.11*/("""<span class="label label-important issue-status">Closed</span>
          <span class="muted">
            """),_display_(/*57.14*/helpers/*57.21*/.user(issue.openedUserName, styleClass = "username strong")),format.raw/*57.80*/("""
            """),format.raw/*58.13*/("""wants to merge """),_display_(/*58.29*/commits/*58.36*/.size),format.raw/*58.41*/(""" """),_display_(/*58.43*/helpers/*58.50*/.plural(commits.size, "commit")),format.raw/*58.81*/("""
            """),format.raw/*59.13*/("""into <code><a href=""""),_display_(/*59.34*/helpers/*59.41*/.basePRBranchUrl(pullreq)),format.raw/*59.66*/("""">"""),_display_(/*59.69*/pullreq/*59.76*/.userName),format.raw/*59.85*/(""":"""),_display_(/*59.87*/pullreq/*59.94*/.branch),format.raw/*59.101*/("""</a></code>
            from <code><a href=""""),_display_(/*60.34*/helpers/*60.41*/.requestPRBranchUrl(pullreq)),format.raw/*60.69*/("""">"""),_display_(/*60.72*/pullreq/*60.79*/.requestUserName),format.raw/*60.95*/(""":"""),_display_(/*60.97*/pullreq/*60.104*/.requestBranch),format.raw/*60.118*/("""</a></code>
          </span>
        """)))}),format.raw/*62.10*/("""
      """)))}else/*63.14*/{_display_(Seq[Any](format.raw/*63.15*/("""
        """),format.raw/*64.9*/("""<span class="label label-success issue-status">Open</span>
        <span class="muted">
          """),_display_(/*66.12*/helpers/*66.19*/.user(issue.openedUserName, styleClass = "username strong")),format.raw/*66.78*/("""
          """),format.raw/*67.11*/("""wants to merge """),_display_(/*67.27*/commits/*67.34*/.size),format.raw/*67.39*/(""" """),_display_(/*67.41*/helpers/*67.48*/.plural(commits.size, "commit")),format.raw/*67.79*/("""
          """),format.raw/*68.11*/("""into <code><a href=""""),_display_(/*68.32*/helpers/*68.39*/.basePRBranchUrl(pullreq)),format.raw/*68.64*/("""">"""),_display_(/*68.67*/pullreq/*68.74*/.userName),format.raw/*68.83*/(""":"""),_display_(/*68.85*/pullreq/*68.92*/.branch),format.raw/*68.99*/("""</a></code>
          from <code><a href=""""),_display_(/*69.32*/helpers/*69.39*/.requestPRBranchUrl(pullreq)),format.raw/*69.67*/("""">"""),_display_(/*69.70*/pullreq/*69.77*/.requestUserName),format.raw/*69.93*/(""":"""),_display_(/*69.95*/pullreq/*69.102*/.requestBranch),format.raw/*69.116*/("""</a></code>
        </span>
      """)))}),format.raw/*71.8*/("""
      """),format.raw/*72.7*/("""</div>
      <ul class="nav nav-tabs fill-width" id="pullreq-tab">
        <li """),_display_(if(active=="conversation")/*74.40*/{_display_(Seq[Any](format.raw/*74.41*/("""class="active"""")))} else {null} ),format.raw/*74.56*/("""><a href=""""),_display_(/*74.67*/helpers/*74.74*/.url(repository)),format.raw/*74.90*/("""/pull/"""),_display_(/*74.97*/issue/*74.102*/.issueId),format.raw/*74.110*/("""">Conversation <span class="badge">"""),_display_(/*74.146*/countConversation(comments)),format.raw/*74.173*/("""</span></a></li>
        <li """),_display_(if(active=="commits")/*75.35*/{_display_(Seq[Any](format.raw/*75.36*/("""class="active"""")))} else {null} ),format.raw/*75.51*/("""><a href=""""),_display_(/*75.62*/helpers/*75.69*/.url(repository)),format.raw/*75.85*/("""/pull/"""),_display_(/*75.92*/issue/*75.97*/.issueId),format.raw/*75.105*/("""/commits">Commits <span class="badge">"""),_display_(/*75.144*/commits/*75.151*/.size),format.raw/*75.156*/("""</span></a></li>
        <li """),_display_(if(active=="files")/*76.33*/{_display_(Seq[Any](format.raw/*76.34*/("""class="active"""")))} else {null} ),format.raw/*76.49*/("""><a href=""""),_display_(/*76.60*/helpers/*76.67*/.url(repository)),format.raw/*76.83*/("""/pull/"""),_display_(/*76.90*/issue/*76.95*/.issueId),format.raw/*76.103*/("""/files">Files Changed <span class="badge">"""),_display_(/*76.146*/changedFileSize),format.raw/*76.161*/("""</span></a></li>
      </ul>
      <div class="tab-content fill-width" style="padding-top: 20px;">
        """),_display_(/*79.10*/flash/*79.15*/.get("error").map/*79.32*/ { error =>_display_(Seq[Any](format.raw/*79.43*/("""
          """),format.raw/*80.11*/("""<div class="alert alert-error">"""),_display_(/*80.43*/error),format.raw/*80.48*/("""</div>
        """)))}),format.raw/*81.10*/("""
        """),_display_(/*82.10*/flash/*82.15*/.get("info").map/*82.31*/ { info =>_display_(Seq[Any](format.raw/*82.41*/("""
          """),format.raw/*83.11*/("""<div class="alert alert-info">"""),_display_(/*83.42*/info),format.raw/*83.46*/("""</div>
        """)))}),format.raw/*84.10*/("""
        """),_display_(/*85.10*/body),format.raw/*85.14*/("""
      """),format.raw/*86.7*/("""</div>
  """)))}),format.raw/*87.4*/("""
""")))}),format.raw/*88.2*/("""
"""),format.raw/*89.1*/("""<script>
  $(function()"""),format.raw/*90.15*/("""{"""),format.raw/*90.16*/("""
   """),format.raw/*91.4*/("""$('#edit').click(function()"""),format.raw/*91.31*/("""{"""),format.raw/*91.32*/("""
      """),format.raw/*92.7*/("""$('.edit-title').show();
      $('.show-title').hide();
      $('#edit-title').focus();
      return false;
    """),format.raw/*96.5*/("""}"""),format.raw/*96.6*/(""");

    $('#update').click(function()"""),format.raw/*98.34*/("""{"""),format.raw/*98.35*/("""
      """),format.raw/*99.7*/("""$(this).attr('disabled', 'disabled');
      $.ajax("""),format.raw/*100.14*/("""{"""),format.raw/*100.15*/("""
        """),format.raw/*101.9*/("""url: '"""),_display_(/*101.16*/helpers/*101.23*/.url(repository)),format.raw/*101.39*/("""/issues/edit_title/"""),_display_(/*101.59*/issue/*101.64*/.issueId),format.raw/*101.72*/("""',
        type: 'POST',
        data: """),format.raw/*103.15*/("""{"""),format.raw/*103.16*/("""
          """),format.raw/*104.11*/("""title   : $('#edit-title').val()
        """),format.raw/*105.9*/("""}"""),format.raw/*105.10*/("""
      """),format.raw/*106.7*/("""}"""),format.raw/*106.8*/(""").done(function(data)"""),format.raw/*106.29*/("""{"""),format.raw/*106.30*/("""
        """),format.raw/*107.9*/("""$('#show-title').empty().text(data.title);
        $('#cancel').click();
        $(this).removeAttr('disabled');
      """),format.raw/*110.7*/("""}"""),format.raw/*110.8*/(""").fail(function(req)"""),format.raw/*110.28*/("""{"""),format.raw/*110.29*/("""
        """),format.raw/*111.9*/("""$(this).removeAttr('disabled');
        $('#error-edit-title').text($.parseJSON(req.responseText).title);
      """),format.raw/*113.7*/("""}"""),format.raw/*113.8*/(""");
      return false;
    """),format.raw/*115.5*/("""}"""),format.raw/*115.6*/(""");

    $('#cancel').click(function()"""),format.raw/*117.34*/("""{"""),format.raw/*117.35*/("""
      """),format.raw/*118.7*/("""$('.edit-title').hide();
      $('.show-title').show();
      return false;
    """),format.raw/*121.5*/("""}"""),format.raw/*121.6*/(""");
  """),format.raw/*122.3*/("""}"""),format.raw/*122.4*/(""");
</script>

"""),format.raw/*130.2*/("""
"""))
      }
    }
  }

  def render(active:String,issue:gitbucket.core.model.Issue,pullreq:gitbucket.core.model.PullRequest,commits:Seq[gitbucket.core.util.JGitUtil.CommitInfo],comments:Seq[gitbucket.core.model.Comment],changedFileSize:Int,isManageable:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,flash:Map[String, String],body:Html,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(active,issue,pullreq,commits,comments,changedFileSize,isManageable,repository,flash)(body)(context)

  def f:((String,gitbucket.core.model.Issue,gitbucket.core.model.PullRequest,Seq[gitbucket.core.util.JGitUtil.CommitInfo],Seq[gitbucket.core.model.Comment],Int,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,Map[String, String]) => (=> Html) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (active,issue,pullreq,commits,comments,changedFileSize,isManageable,repository,flash) => (body) => (context) => apply(active,issue,pullreq,commits,comments,changedFileSize,isManageable,repository,flash)(body)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/pulls/menu.scala.html
                  HASH: 7f031207a80730757f960be6f3643b65053f95ab
                  MATRIX: 847->1|1353->435|1396->471|1440->508|1491->552|1546->5637|1573->5654|1771->594|1789->603|1925->729|1966->731|1996->735|2014->744|2059->780|2099->782|2133->789|2319->947|2360->949|2401->962|2511->1028|2584->1074|2624->1076|2665->1089|2726->1123|2742->1130|2779->1146|2865->1188|2901->1197|3258->1527|3272->1532|3299->1538|3368->1580|3382->1585|3411->1593|3683->1838|3698->1843|3726->1849|3865->1961|3905->1963|3942->1973|3959->1981|3977->1991|4077->2081|4116->2111|4167->2124|4203->2133|4328->2231|4344->2238|4429->2302|4468->2313|4503->2321|4519->2328|4545->2333|4574->2335|4590->2342|4642->2373|4681->2384|4729->2405|4745->2412|4791->2437|4821->2440|4837->2447|4867->2456|4896->2458|4912->2465|4940->2472|5010->2515|5026->2522|5075->2550|5105->2553|5121->2560|5158->2576|5187->2578|5204->2585|5240->2599|5290->2622|5308->2631|5382->2684|5418->2693|5454->2710|5473->2720|5513->2722|5552->2733|5686->2840|5702->2847|5782->2906|5823->2919|5866->2935|5882->2942|5908->2947|5937->2949|5953->2956|6005->2987|6046->3000|6094->3021|6110->3028|6156->3053|6186->3056|6202->3063|6232->3072|6261->3074|6277->3081|6306->3088|6378->3133|6394->3140|6443->3168|6473->3171|6489->3178|6526->3194|6555->3196|6572->3203|6608->3217|6678->3256|6709->3270|6748->3271|6784->3280|6910->3379|6926->3386|7006->3445|7045->3456|7088->3472|7104->3479|7130->3484|7159->3486|7175->3493|7227->3524|7266->3535|7314->3556|7330->3563|7376->3588|7406->3591|7422->3598|7452->3607|7481->3609|7497->3616|7525->3623|7595->3666|7611->3673|7660->3701|7690->3704|7706->3711|7743->3727|7772->3729|7789->3736|7825->3750|7890->3785|7924->3792|8057->3898|8096->3899|8155->3914|8193->3925|8209->3932|8246->3948|8280->3955|8295->3960|8325->3968|8389->4004|8438->4031|8516->4082|8555->4083|8614->4098|8652->4109|8668->4116|8705->4132|8739->4139|8753->4144|8783->4152|8850->4191|8867->4198|8894->4203|8970->4252|9009->4253|9068->4268|9106->4279|9122->4286|9159->4302|9193->4309|9207->4314|9237->4322|9308->4365|9345->4380|9480->4488|9494->4493|9520->4510|9569->4521|9608->4532|9667->4564|9693->4569|9740->4585|9777->4595|9791->4600|9816->4616|9864->4626|9903->4637|9961->4668|9986->4672|10033->4688|10070->4698|10095->4702|10129->4709|10169->4719|10201->4721|10229->4722|10280->4745|10309->4746|10340->4750|10395->4777|10424->4778|10458->4785|10597->4897|10625->4898|10690->4935|10719->4936|10753->4943|10833->4994|10863->4995|10900->5004|10935->5011|10952->5018|10990->5034|11038->5054|11053->5059|11083->5067|11151->5106|11181->5107|11221->5118|11290->5159|11320->5160|11355->5167|11384->5168|11434->5189|11464->5190|11501->5199|11648->5318|11677->5319|11726->5339|11756->5340|11793->5349|11933->5461|11962->5462|12017->5489|12046->5490|12112->5527|12142->5528|12177->5535|12285->5615|12314->5616|12347->5621|12376->5622|12418->5822
                  LINES: 14->1|25->10|26->11|27->12|28->13|30->125|30->125|36->14|36->14|36->14|36->14|37->15|37->15|37->15|37->15|38->16|40->18|40->18|41->19|42->20|43->21|43->21|44->22|44->22|44->22|44->22|45->23|46->24|53->31|53->31|53->31|54->32|54->32|54->32|58->36|58->36|58->36|63->41|63->41|64->42|64->42|64->42|67->45|67->45|67->45|68->46|70->48|70->48|70->48|71->49|71->49|71->49|71->49|71->49|71->49|71->49|72->50|72->50|72->50|72->50|72->50|72->50|72->50|72->50|72->50|72->50|73->51|73->51|73->51|73->51|73->51|73->51|73->51|73->51|73->51|74->52|74->52|74->52|75->53|76->54|76->54|76->54|77->55|79->57|79->57|79->57|80->58|80->58|80->58|80->58|80->58|80->58|80->58|81->59|81->59|81->59|81->59|81->59|81->59|81->59|81->59|81->59|81->59|82->60|82->60|82->60|82->60|82->60|82->60|82->60|82->60|82->60|84->62|85->63|85->63|86->64|88->66|88->66|88->66|89->67|89->67|89->67|89->67|89->67|89->67|89->67|90->68|90->68|90->68|90->68|90->68|90->68|90->68|90->68|90->68|90->68|91->69|91->69|91->69|91->69|91->69|91->69|91->69|91->69|91->69|93->71|94->72|96->74|96->74|96->74|96->74|96->74|96->74|96->74|96->74|96->74|96->74|96->74|97->75|97->75|97->75|97->75|97->75|97->75|97->75|97->75|97->75|97->75|97->75|97->75|98->76|98->76|98->76|98->76|98->76|98->76|98->76|98->76|98->76|98->76|98->76|101->79|101->79|101->79|101->79|102->80|102->80|102->80|103->81|104->82|104->82|104->82|104->82|105->83|105->83|105->83|106->84|107->85|107->85|108->86|109->87|110->88|111->89|112->90|112->90|113->91|113->91|113->91|114->92|118->96|118->96|120->98|120->98|121->99|122->100|122->100|123->101|123->101|123->101|123->101|123->101|123->101|123->101|125->103|125->103|126->104|127->105|127->105|128->106|128->106|128->106|128->106|129->107|132->110|132->110|132->110|132->110|133->111|135->113|135->113|137->115|137->115|139->117|139->117|140->118|143->121|143->121|144->122|144->122|147->130
                  -- GENERATED --
              */
          