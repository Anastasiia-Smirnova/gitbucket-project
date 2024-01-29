
package gitbucket.core.admin.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object settings_system extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(info: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.util.DatabaseConfig


Seq[Any](format.raw/*3.1*/("""<!--====================================================================-->
<!-- System properties -->
<!--====================================================================-->
<table class="table table-bordered">
  <tr>
    <th>Property</th>
    <th>Value</th>
  </tr>
  <tr>
    <td>GITBUCKET_VERSION</td>
    <td>"""),_display_(/*13.10*/gitbucket/*13.19*/.core.GitBucketCoreModule.getVersions.last.getVersion),format.raw/*13.72*/("""</td>
  </tr>
  <tr>
    <td>GITBUCKET_HOME</td>
    <td>"""),_display_(/*17.10*/gitbucket/*17.19*/.core.util.Directory.GitBucketHome),format.raw/*17.53*/("""</td>
  </tr>
  <tr>
    <td>DATABASE_URL</td>
    """),_display_(if(DatabaseConfig.url.startsWith("jdbc:h2:"))/*21.51*/ {_display_(Seq[Any](format.raw/*21.53*/("""
    """),format.raw/*22.5*/("""<td class="danger">
      <p>"""),_display_(/*23.11*/gitbucket/*23.20*/.core.util.DatabaseConfig.url),format.raw/*23.49*/("""</p>
      <p>
        GitBucket is using the embedded H2 database.
        It's recommended that you <a href="https://github.com/gitbucket/gitbucket/wiki/External-database-configuration">configure GitBucket to use an external database</a> if you're running GitBucket in a production environment.
      </p>
    </td>
    """)))}else/*29.10*/{_display_(Seq[Any](format.raw/*29.11*/("""
      """),format.raw/*30.7*/("""<td>"""),_display_(/*30.12*/gitbucket/*30.21*/.core.util.DatabaseConfig.url),format.raw/*30.50*/("""</td>
    """)))}),format.raw/*31.6*/("""
  """),format.raw/*32.3*/("""</tr>
</table>
<!--====================================================================-->
<!-- Base URL -->
<!--====================================================================-->
<hr>
<label for="baseUrl"><span class="strong">Base URL</span> (e.g. <code>http://example.com/gitbucket</code>)</label>
<fieldset>
    <div class="controls">
      <input type="text" name="baseUrl" id="baseUrl" class="form-control" value=""""),_display_(/*41.83*/context/*41.90*/.settings.baseUrl),format.raw/*41.107*/(""""/>
      <span id="error-baseUrl" class="error"></span>
    </div>
</fieldset>
<p class="muted">
  The base URL is used for redirects, notification emails, git repository URL boxes, and more.
  If the base URL is empty, GitBucket generates the URL from the request information.
  You can use this property to adjust to URL differences between a reverse proxy and GitBucket.
</p>
<!--====================================================================-->
<!-- Information -->
<!--====================================================================-->
<hr>
<label for="information"><span class="strong">Site notification</span> (Supports HTML)</label>
<fieldset>
  <textarea id="information" name="information" class="form-control" style="height: 100px;">"""),_display_(/*56.94*/context/*56.101*/.settings.information),format.raw/*56.122*/("""</textarea>
</fieldset>
<!--====================================================================-->
<!-- Default branch -->
<!--====================================================================-->
<hr>
<label for="defaultBranch"><span class="strong">Default branch</span></label>
<fieldset>
  <input type="text" name="defaultBranch" id="defaultBranch" class="form-control" value=""""),_display_(/*64.91*/context/*64.98*/.settings.defaultBranch),format.raw/*64.121*/(""""/>
  <span id="error-defaultBranch" class="error"></span>
</fieldset>
<!--====================================================================-->
<!-- AdminLTE SkinName -->
<!--====================================================================-->
<hr>
<label class="strong">
  AdminLTE skin name
</label>
<div class="form-group">
  <label class="control-label col-md-2" for="skinName">Skin name</label>
  <div class="col-md-10">
    <select id="skinName" name="skinName" class="form-control">
      <optgroup label="Dark">
        """),_display_(/*79.10*/Seq(
        ("skin-black", "Black"),
        ("skin-blue", "Blue"),
        ("skin-green", "Green"),
        ("skin-purple", "Purple"),
        ("skin-red", "Red"),
        ("skin-yellow", "Yellow"),
        )/*86.10*/.map/*86.14*/{ skin =>_display_(Seq[Any](format.raw/*86.23*/("""
          """),format.raw/*87.11*/("""<option value=""""),_display_(/*87.27*/skin/*87.31*/._1),format.raw/*87.34*/("""""""),_display_(if(skin._1 == context.settings.skinName)/*87.76*/{_display_(Seq[Any](format.raw/*87.77*/(""" """),format.raw/*87.78*/("""selected=""""")))} else {null} ),format.raw/*87.90*/(""">"""),_display_(/*87.92*/skin/*87.96*/._2),format.raw/*87.99*/("""</option>
        """)))}),format.raw/*88.10*/("""
      """),format.raw/*89.7*/("""</optgroup>
      <optgroup label="Light">
        """),_display_(/*91.10*/Seq(
        ("skin-black-light", "Light black"),
        ("skin-blue-light", "Light blue"),
        ("skin-green-light", "Light green"),
        ("skin-purple-light", "Light purple"),
        ("skin-red-light", "Light red"),
        ("skin-yellow-light", "Light yellow"),
        )/*98.10*/.map/*98.14*/{ skin =>_display_(Seq[Any](format.raw/*98.23*/("""
          """),format.raw/*99.11*/("""<option value=""""),_display_(/*99.27*/skin/*99.31*/._1),format.raw/*99.34*/("""""""),_display_(if(skin._1 == context.settings.skinName)/*99.76*/{_display_(Seq[Any](format.raw/*99.77*/(""" """),format.raw/*99.78*/("""selected=""""")))} else {null} ),format.raw/*99.90*/(""" """),format.raw/*99.91*/(""">"""),_display_(/*99.93*/skin/*99.97*/._2),format.raw/*99.100*/("""</option>
        """)))}),format.raw/*100.10*/("""
      """),format.raw/*101.7*/("""</optgroup>
    </select>
  </div>
</div>
<!--====================================================================-->
<!-- User-defined CSS -->
<!--====================================================================-->
<hr>
<label for="userDefinedCss"><span class="strong">User-defined CSS</span></label>
<fieldset>
  <textarea id="userDefinedCss" name="userDefinedCss" class="form-control" style="height: 100px;">"""),_display_(/*111.100*/context/*111.107*/.settings.userDefinedCss),format.raw/*111.131*/("""</textarea>
</fieldset>
<!--====================================================================-->
<!-- Account registration -->
<!--====================================================================-->
<hr>
<label class="strong">Account registration</label>
<fieldset>
  <label class="radio">
    <input type="radio" name="basicBehavior.allowAccountRegistration" value="true""""),_display_(if(context.settings.basicBehavior.allowAccountRegistration)/*120.143*/{_display_(Seq[Any](format.raw/*120.144*/(""" """),format.raw/*120.145*/("""checked""")))} else {null} ),format.raw/*120.153*/(""">
    <span class="strong">Allow</span> <span class="normal">- Users can create accounts by themselves.</span>
  </label>
  <label class="radio">
    <input type="radio" name="basicBehavior.allowAccountRegistration" value="false""""),_display_(if(!context.settings.basicBehavior.allowAccountRegistration)/*124.145*/{_display_(Seq[Any](format.raw/*124.146*/(""" """),format.raw/*124.147*/("""checked""")))} else {null} ),format.raw/*124.155*/(""">
    <span class="strong">Deny</span> <span class="normal">- Only administrators can create accounts.</span>
  </label>
</fieldset>
<!--====================================================================-->
<!-- Reset password -->
<!--====================================================================-->
<hr>
<label class="strong">Reset password</label>
<fieldset>
  <label class="radio">
    <input type="radio" name="basicBehavior.allowResetPassword" value="true""""),_display_(if(context.settings.basicBehavior.allowResetPassword)/*135.131*/{_display_(Seq[Any](format.raw/*135.132*/(""" """),format.raw/*135.133*/("""checked""")))} else {null} ),format.raw/*135.141*/(""">
    <span class="strong">Allow</span> <span class="normal">- Allow users to reset password. (SMTP setting is required)</span>
  </label>
  <label class="radio">
    <input type="radio" name="basicBehavior.allowResetPassword" value="false""""),_display_(if(!context.settings.basicBehavior.allowResetPassword)/*139.133*/{_display_(Seq[Any](format.raw/*139.134*/(""" """),format.raw/*139.135*/("""checked""")))} else {null} ),format.raw/*139.143*/(""">
    <span class="strong">Deny</span> <span class="normal">- Doesn't allow users to reset password.</span>
  </label>
</fieldset>
<!--====================================================================-->
<!-- Repository operations -->
<!--====================================================================-->
<hr>
<label class="strong">Repository operation</label>
<fieldset>
  <div class="form-group">
    <label class="control-label col-md-2">Create</label>
    <div class="col-md-10">
      <label class="radio">
        <input type="radio" name="basicBehavior.repositoryOperation.create" value="true""""),_display_(if(context.settings.basicBehavior.repositoryOperation.create)/*153.151*/{_display_(Seq[Any](format.raw/*153.152*/(""" """),format.raw/*153.153*/("""checked""")))} else {null} ),format.raw/*153.161*/(""">
        <span class="strong">All users</span> <span class="normal">- All users can create repository.</span>
      </label>
      <label class="radio">
        <input type="radio" name="basicBehavior.repositoryOperation.create" value="false""""),_display_(if(!context.settings.basicBehavior.repositoryOperation.create)/*157.153*/{_display_(Seq[Any](format.raw/*157.154*/(""" """),format.raw/*157.155*/("""checked""")))} else {null} ),format.raw/*157.163*/(""">
        <span class="strong">Admin only</span> <span class="normal">- Only administrators can create repository.</span>
      </label>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2">Delete</label>
    <div class="col-md-10">
      <label class="radio">
        <input type="radio" name="basicBehavior.repositoryOperation.delete" value="true""""),_display_(if(context.settings.basicBehavior.repositoryOperation.delete)/*166.151*/{_display_(Seq[Any](format.raw/*166.152*/(""" """),format.raw/*166.153*/("""checked""")))} else {null} ),format.raw/*166.161*/(""">
        <span class="strong">All users</span> <span class="normal">- All users can delete repository.</span>
      </label>
      <label class="radio">
        <input type="radio" name="basicBehavior.repositoryOperation.delete" value="false""""),_display_(if(!context.settings.basicBehavior.repositoryOperation.delete)/*170.153*/{_display_(Seq[Any](format.raw/*170.154*/(""" """),format.raw/*170.155*/("""checked""")))} else {null} ),format.raw/*170.163*/(""">
        <span class="strong">Admin only</span> <span class="normal">- Only administrators can delete repository.</span>
      </label>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2">Rename</label>
    <div class="col-md-10">
      <label class="radio">
        <input type="radio" name="basicBehavior.repositoryOperation.rename" value="true""""),_display_(if(context.settings.basicBehavior.repositoryOperation.rename)/*179.151*/{_display_(Seq[Any](format.raw/*179.152*/(""" """),format.raw/*179.153*/("""checked""")))} else {null} ),format.raw/*179.161*/(""">
        <span class="strong">All users</span> <span class="normal">- All users can rename repository.</span>
      </label>
      <label class="radio">
        <input type="radio" name="basicBehavior.repositoryOperation.rename" value="false""""),_display_(if(!context.settings.basicBehavior.repositoryOperation.rename)/*183.153*/{_display_(Seq[Any](format.raw/*183.154*/(""" """),format.raw/*183.155*/("""checked""")))} else {null} ),format.raw/*183.163*/(""">
        <span class="strong">Admin only</span> <span class="normal">- Only administrators can rename repository.</span>
      </label>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2">Transfer</label>
    <div class="col-md-10">
      <label class="radio">
        <input type="radio" name="basicBehavior.repositoryOperation.transfer" value="true""""),_display_(if(context.settings.basicBehavior.repositoryOperation.transfer)/*192.155*/{_display_(Seq[Any](format.raw/*192.156*/(""" """),format.raw/*192.157*/("""checked""")))} else {null} ),format.raw/*192.165*/(""">
        <span class="strong">All users</span> <span class="normal">- All users can transfer repository.</span>
      </label>
      <label class="radio">
        <input type="radio" name="basicBehavior.repositoryOperation.transfer" value="false""""),_display_(if(!context.settings.basicBehavior.repositoryOperation.transfer)/*196.157*/{_display_(Seq[Any](format.raw/*196.158*/(""" """),format.raw/*196.159*/("""checked""")))} else {null} ),format.raw/*196.167*/(""">
        <span class="strong">Admin only</span> <span class="normal">- Only administrators can transfer repository.</span>
      </label>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2">Fork</label>
    <div class="col-md-10">
      <label class="radio">
        <input type="radio" name="basicBehavior.repositoryOperation.fork" value="true""""),_display_(if(context.settings.basicBehavior.repositoryOperation.fork)/*205.147*/{_display_(Seq[Any](format.raw/*205.148*/(""" """),format.raw/*205.149*/("""checked""")))} else {null} ),format.raw/*205.157*/(""">
        <span class="strong">All users</span> <span class="normal">- All users can fork repository.</span>
      </label>
      <label class="radio">
        <input type="radio" name="basicBehavior.repositoryOperation.fork" value="false""""),_display_(if(!context.settings.basicBehavior.repositoryOperation.fork)/*209.149*/{_display_(Seq[Any](format.raw/*209.150*/(""" """),format.raw/*209.151*/("""checked""")))} else {null} ),format.raw/*209.159*/(""">
        <span class="strong">Admin only</span> <span class="normal">- Only administrators can fork repository.</span>
      </label>
    </div>
  </div>
</fieldset>
<hr>
<label class="strong">Default visibility when creating a new repository</label>
<fieldset>
  <label class="radio">
    <input type="radio" name="basicBehavior.isCreateRepoOptionPublic" value="true""""),_display_(if(context.settings.basicBehavior.isCreateRepoOptionPublic)/*219.143*/{_display_(Seq[Any](format.raw/*219.144*/(""" """),format.raw/*219.145*/("""checked""")))} else {null} ),format.raw/*219.153*/(""">
    <span class="strong">Public</span> <span class="normal">- All users and guests can read the repository.</span>
  </label>
  <label class="radio">
    <input type="radio" name="basicBehavior.isCreateRepoOptionPublic" value="false""""),_display_(if(!context.settings.basicBehavior.isCreateRepoOptionPublic)/*223.145*/{_display_(Seq[Any](format.raw/*223.146*/(""" """),format.raw/*223.147*/("""checked""")))} else {null} ),format.raw/*223.155*/(""">
    <span class="strong">Private</span> <span class="normal">- Only collaborators can read the repository.</span>
  </label>
</fieldset>
<!--====================================================================-->
<!-- Anonymous access -->
<!--====================================================================-->
<hr>
<label class="strong">Anonymous access</label>
<fieldset>
  <label class="radio">
    <input type="radio" name="basicBehavior.allowAnonymousAccess" value="true""""),_display_(if(context.settings.basicBehavior.allowAnonymousAccess)/*234.135*/{_display_(Seq[Any](format.raw/*234.136*/(""" """),format.raw/*234.137*/("""checked""")))} else {null} ),format.raw/*234.145*/(""">
    <span class="strong">Allow</span> <span class="normal">- Anyone can view public repositories and user/group profiles.</span>
  </label>
  <label class="radio">
    <input type="radio" name="basicBehavior.allowAnonymousAccess" value="false""""),_display_(if(!context.settings.basicBehavior.allowAnonymousAccess)/*238.137*/{_display_(Seq[Any](format.raw/*238.138*/(""" """),format.raw/*238.139*/("""checked""")))} else {null} ),format.raw/*238.147*/(""">
    <span class="strong">Deny</span> <span class="normal">- Users must authenticate before viewing any information.</span>
  </label>
</fieldset>
<!--====================================================================-->
<!-- Show mail address -->
<!--====================================================================-->
<hr>
<label class="strong">Show mail address</label>
<fieldset>
  <label class="radio">
    <input type="radio" name="showMailAddress" value="true""""),_display_(if(context.settings.showMailAddress)/*249.97*/{_display_(Seq[Any](format.raw/*249.98*/(""" """),format.raw/*249.99*/("""checked""")))} else {null} ),format.raw/*249.107*/(""">
    <span class="strong">Show</span> <span class="normal">- Anyone can view mail address by user's profile page.</span>
  </label>
  <label class="radio">
    <input type="radio" name="showMailAddress" value="false""""),_display_(if(!context.settings.showMailAddress)/*253.99*/{_display_(Seq[Any](format.raw/*253.100*/(""" """),format.raw/*253.101*/("""checked""")))} else {null} ),format.raw/*253.109*/(""">
    <span class="strong">Hide</span> <span class="normal">- Hide mail address in user's profile page.</span>
  </label>
</fieldset>
<!--====================================================================-->
<!-- File upload -->
<!--====================================================================-->
<hr>
<label class="strong">File upload</label>
<fieldset>
  <div class="form-group">
    <label class="control-label col-md-2" for="uploadMaxFileSize">Max size</label>
    <div class="col-md-10">
      <input type="text" id="uploadMaxFileSize" name="upload.maxFileSize" class="form-control input-mini" value=""""),_display_(/*266.115*/context/*266.122*/.settings.upload.maxFileSize),format.raw/*266.150*/(""""/>
      <span id="error-upload_maxFileSize" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="uploadTimeout">Timeout</label>
    <div class="col-md-10">
      <input type="text" id="uploadTimeout" name="upload.timeout" class="form-control input-mini" value=""""),_display_(/*273.107*/context/*273.114*/.settings.upload.timeout),format.raw/*273.138*/(""""/>
      <span id="error-upload_timeout" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="uploadLargeMaxFileSize">Max size for large files</label>
    <div class="col-md-10">
      <input type="text" id="uploadLargeMaxFileSize" name="upload.largeMaxFileSize" class="form-control input-mini" value=""""),_display_(/*280.125*/context/*280.132*/.settings.upload.largeMaxFileSize),format.raw/*280.165*/(""""/>
      <span id="error-upload_largeMaxFileSize" class="error"></span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="uploadLargeTimeout">Timeout for large files</label>
    <div class="col-md-10">
      <input type="text" id="uploadLargeTimeout" name="upload.largeTimeout" class="form-control input-mini" value=""""),_display_(/*287.117*/context/*287.124*/.settings.upload.largeTimeout),format.raw/*287.153*/(""""/>
      <span id="error-upload_largeTimeout" class="error"></span>
    </div>
  </div>
</fieldset>
<!--====================================================================-->
<!-- Sidebar -->
<!--====================================================================-->
<hr>
<label><span class="strong">Show repositories in sidebar</span></label>
<fieldset>
  <label class="radio">
    <input type="radio" name="basicBehavior.limitVisibleRepositories" value="false""""),_display_(if(!context.settings.basicBehavior.limitVisibleRepositories)/*299.145*/{_display_(Seq[Any](format.raw/*299.146*/(""" """),format.raw/*299.147*/("""checked""")))} else {null} ),format.raw/*299.155*/(""">
    <span class="strong">All</span> <span class="normal">- Show all visible repositories in sidebar.</span>
  </label>
  <label class="radio">
    <input type="radio" name="basicBehavior.limitVisibleRepositories" value="true""""),_display_(if(context.settings.basicBehavior.limitVisibleRepositories)/*303.143*/{_display_(Seq[Any](format.raw/*303.144*/(""" """),format.raw/*303.145*/("""checked""")))} else {null} ),format.raw/*303.153*/(""">
    <span class="strong">Limited</span> <span class="normal">- Show only owned repositories in sidebar.</span>
  </label>
</fieldset>
<!--====================================================================-->
<!-- Repository viewer -->
<!--====================================================================-->
<hr>
<label><span class="strong">Repository viewer</span></label>
<fieldset>
  <div class="form-group">
    <label class="control-label col-md-2" for="repositoryViewerMaxFiles">Max files in directory</label>
    <div class="col-md-10">
      <input type="text" name="repositoryViewer.maxFiles" id="repositoryViewerMaxFiles" class="form-control" value=""""),_display_(/*316.118*/context/*316.125*/.settings.repositoryViewer.maxFiles),format.raw/*316.160*/(""""/>
      <span id="error-repositoryViewerMaxFiles" class="error"></span>
      <p class="muted">
        If the number of files in the directory is bigger than this number, GitBucket doesn't show detailed commit info on the repository viewer
        because it can make the entire system quite heavy. 0 or negative number means no limitation.
      </p>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="repositoryViewerMaxDiffFiles">Max files in diff</label>
    <div class="col-md-10">
      <input type="text" name="repositoryViewer.maxDiffFiles" id="repositoryViewerMaxDiffFiles" class="form-control" value=""""),_display_(/*327.126*/context/*327.133*/.settings.repositoryViewer.maxDiffFiles),format.raw/*327.172*/(""""/>
      <span id="error-repositoryViewerMaxDiffFiles" class="error"></span>
      <p class="muted">
        Avoid showing diff to prevent browser freezes if number of files in diff is bigger than this value. 0 or negative number means no limitation.
      </p>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-md-2" for="repositoryViewerMaxDiffLines">Max lines in diff</label>
    <div class="col-md-10">
      <input type="text" name="repositoryViewer.maxDiffLines" id="repositoryViewerMaxDiffLines" class="form-control" value=""""),_display_(/*337.126*/context/*337.133*/.settings.repositoryViewer.maxDiffLines),format.raw/*337.172*/(""""/>
      <span id="error-repositoryViewerMaxDiffLines" class="error"></span>
      <p class="muted">
        Avoid showing diff to prevent browser freezes if lines of diff in a file is bigger than this value. 0 or negative number means no limitation.
      </p>
    </div>
  </div>
</fieldset>

<script>
$(function()"""),format.raw/*347.13*/("""{"""),format.raw/*347.14*/("""
  """),format.raw/*348.3*/("""$('#skinName').change(function(evt) """),format.raw/*348.39*/("""{"""),format.raw/*348.40*/("""
    """),format.raw/*349.5*/("""var that = $(evt.target);
    var themeCss = $('link[rel="stylesheet"][href*="skin-"]');
    var oldVal = new RegExp('(skin-.*?).min.css').exec(themeCss.attr('href'))[1];
    themeCss.attr('href', themeCss.attr('href').replace(oldVal, that.val()));
    $(document.body).removeClass(oldVal).addClass(that.val());
  """),format.raw/*354.3*/("""}"""),format.raw/*354.4*/(""");
"""),format.raw/*355.1*/("""}"""),format.raw/*355.2*/(""");
</script>
"""))
      }
    }
  }

  def render(info:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(info)(context)

  def f:((Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (info) => (context) => apply(info)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/admin/settings_system.scala.html
                  HASH: 67bf81a3a98367d00c658a1f82be753a0257e8cb
                  MATRIX: 630->1|775->75|845->117|1191->436|1209->445|1283->498|1368->556|1386->565|1441->599|1565->696|1605->698|1637->703|1694->733|1712->742|1762->771|2108->1098|2147->1099|2181->1106|2213->1111|2231->1120|2281->1149|2322->1160|2352->1163|2804->1588|2820->1595|2859->1612|3643->2369|3660->2376|3703->2397|4114->2781|4130->2788|4175->2811|4737->3346|4956->3556|4969->3560|5016->3569|5055->3580|5098->3596|5111->3600|5135->3603|5204->3645|5243->3646|5272->3647|5328->3659|5357->3661|5370->3665|5394->3668|5444->3687|5478->3694|5557->3746|5848->4028|5861->4032|5908->4041|5947->4052|5990->4068|6003->4072|6027->4075|6096->4117|6135->4118|6164->4119|6220->4131|6249->4132|6278->4134|6291->4138|6316->4141|6367->4160|6402->4167|6847->4583|6865->4590|6912->4614|7380->5053|7421->5054|7452->5055|7506->5063|7825->5353|7866->5354|7897->5355|7951->5363|8504->5887|8545->5888|8576->5889|8630->5897|8954->6192|8995->6193|9026->6194|9080->6202|9780->6873|9821->6874|9852->6875|9906->6883|10241->7189|10282->7190|10313->7191|10367->7199|10843->7646|10884->7647|10915->7648|10969->7656|11304->7962|11345->7963|11376->7964|11430->7972|11906->8419|11947->8420|11978->8421|12032->8429|12367->8735|12408->8736|12439->8737|12493->8745|12975->9198|13016->9199|13047->9200|13101->9208|13442->9520|13483->9521|13514->9522|13568->9530|14040->9973|14081->9974|14112->9975|14166->9983|14495->10283|14536->10284|14567->10285|14621->10293|15079->10722|15120->10723|15151->10724|15205->10732|15530->11028|15571->11029|15602->11030|15656->11038|16223->11576|16264->11577|16295->11578|16349->11586|16680->11888|16721->11889|16752->11890|16806->11898|17345->12409|17385->12410|17415->12411|17469->12419|17752->12674|17793->12675|17824->12676|17878->12684|18524->13301|18542->13308|18593->13336|18949->13663|18967->13670|19014->13694|19410->14061|19428->14068|19484->14101|19876->14464|19894->14471|19946->14500|20501->15026|20542->15027|20573->15028|20627->15036|20943->15323|20984->15324|21015->15325|21069->15333|21766->16001|21784->16008|21842->16043|22529->16701|22547->16708|22609->16747|23204->17313|23222->17320|23284->17359|23630->17676|23660->17677|23691->17680|23756->17716|23786->17717|23819->17722|24161->18036|24190->18037|24221->18040|24250->18041
                  LINES: 14->1|17->2|20->3|30->13|30->13|30->13|34->17|34->17|34->17|38->21|38->21|39->22|40->23|40->23|40->23|46->29|46->29|47->30|47->30|47->30|47->30|48->31|49->32|58->41|58->41|58->41|73->56|73->56|73->56|81->64|81->64|81->64|96->79|103->86|103->86|103->86|104->87|104->87|104->87|104->87|104->87|104->87|104->87|104->87|104->87|104->87|104->87|105->88|106->89|108->91|115->98|115->98|115->98|116->99|116->99|116->99|116->99|116->99|116->99|116->99|116->99|116->99|116->99|116->99|116->99|117->100|118->101|128->111|128->111|128->111|137->120|137->120|137->120|137->120|141->124|141->124|141->124|141->124|152->135|152->135|152->135|152->135|156->139|156->139|156->139|156->139|170->153|170->153|170->153|170->153|174->157|174->157|174->157|174->157|183->166|183->166|183->166|183->166|187->170|187->170|187->170|187->170|196->179|196->179|196->179|196->179|200->183|200->183|200->183|200->183|209->192|209->192|209->192|209->192|213->196|213->196|213->196|213->196|222->205|222->205|222->205|222->205|226->209|226->209|226->209|226->209|236->219|236->219|236->219|236->219|240->223|240->223|240->223|240->223|251->234|251->234|251->234|251->234|255->238|255->238|255->238|255->238|266->249|266->249|266->249|266->249|270->253|270->253|270->253|270->253|283->266|283->266|283->266|290->273|290->273|290->273|297->280|297->280|297->280|304->287|304->287|304->287|316->299|316->299|316->299|316->299|320->303|320->303|320->303|320->303|333->316|333->316|333->316|344->327|344->327|344->327|354->337|354->337|354->337|364->347|364->347|365->348|365->348|365->348|366->349|371->354|371->354|372->355|372->355
                  -- GENERATED --
              */
          