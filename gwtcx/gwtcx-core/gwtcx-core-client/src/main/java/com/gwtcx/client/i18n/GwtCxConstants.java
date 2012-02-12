/**
 * (C) Copyright 2010, 2011 upTick Pty Ltd
 *
 * Licensed under the terms of the GNU General Public License version 3
 * as published by the Free Software Foundation. You may obtain a copy of the
 * License at: http://www.gnu.org/copyleft/gpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.gwtcx.client.i18n;

/**
 * GwtCxConstants interface to represent the constants contained in a resource bundle.
 */
public interface GwtCxConstants extends com.google.gwt.i18n.client.Constants {

  // Menus

  @DefaultStringValue("<u>N</u>ew Activity")
  String newActivityMenuName();

  @DefaultStringValue("Task, Fax, Phone Call, Email, Letter, Appointment")
  String newActivityMenuItemNames();

  @DefaultStringValue("New Re<u>c</u>ord")
  String newRecordMenuName();

  // @DefaultStringValue("Account, Contact, separator, Lead, Opportunity")
  // newRecordMenuItemNames: Konto, Kontakt, separator, Blei, Gelegenheit
  @DefaultStringValue("Account, Contact")
  String newRecordMenuItemNames();

  @DefaultStringValue("<u>G</u>o To")
  String goToMenuName();

  @DefaultStringValue("Sales")
  String salesMenuItemName();

  @DefaultStringValue("Activities, Calendar, Dashboards, Imports, Accounts, Contacts, Queues, Reports")
  String salesMenuItemNames();
  @DefaultStringValue("Activities")
  String activitiesMenuItemName();
  @DefaultStringValue("Calendar")
  String calendarMenuItemName();
  @DefaultStringValue("Dashboards")
  String dashboardsMenuItemName();
  @DefaultStringValue("Imports")
  String importsMenuItemName();
  @DefaultStringValue("Accounts")
  String accountsMenuItemName();
  @DefaultStringValue("Contacts")
  String contactsMenuItemName();
  @DefaultStringValue("Queues")
  String queuesMenuItemName();
  @DefaultStringValue("Reports")
  String reportsMenuItemName();

  @DefaultStringValue("Settings")
  String settingsMenuItemName();

  @DefaultStringValue("Administration, Templates, Data Management")
  String settingsMenuItemNames();
  @DefaultStringValue("Administration")
  String administrationMenuItemName();
  @DefaultStringValue("Announcements")
  String announcementsMenuItemName();
  @DefaultStringValue("Auto-Numbering")
  String autoNumberingMenuItemName();
  @DefaultStringValue("Business Units")
  String businessUnitsMenuItemName();
  @DefaultStringValue("System Settings")
  String systemSettingsMenuItemName();
  @DefaultStringValue("Users")
  String usersMenuItemName();
  @DefaultStringValue("Teams")
  String teamsMenuItemName();
  @DefaultStringValue("Privacy Preferences")
  String privacyPreferencesMenuItemName();
  @DefaultStringValue("Product Updates")
  String productUpdatesMenuItemName();

  @DefaultStringValue("Templates")
  String templatesMenuItemName();

  @DefaultStringValue("Data Management")
  String dataManagementMenuItemName();

  @DefaultStringValue("Resource Centre")
  String resourceCentreMenuItemName();

  @DefaultStringValue("Highlights, Sales, Settings")
  String resourceCentreMenuItemNames();
  @DefaultStringValue("Highlights")
  String highlightsMenuItemName();

  @DefaultStringValue("<u>T</u>ools")
  String toolsMenuName();

  @DefaultStringValue("Import Data, Duplicate Detection, Advanced Find, Options")
  String toolsMenuItemNames();

  @DefaultStringValue("<u>H</u>elp")
  String helpMenuName();

  @DefaultStringValue("Help on this Page, Contents, Serendipity Online, About Serendipity")
  String helpMenuItemNames();

  // Navigation Pane Header

  @DefaultStringValue("Workplace")
  String workplace();

  @DefaultStringValue("Activities")
  String activities();

  // Navigation Pane

  @DefaultStringValue("Sales")
  String salesNavigationPaneSectionName();

  @DefaultStringValue("Settings")
  String settingsNavigationPaneSectionName();

  @DefaultStringValue("Resource Centre")
  String resourceCentreNavigationPaneSectionName();

  // Entity Navigation Pane

  @DefaultStringValue("Details")
  String accountDetailsNavigationPaneSectionName();

  @DefaultStringValue("Details")
  String contactDetailsNavigationPaneSectionName();

  // ToolBar

  @DefaultStringValue("New")
  String newButton();
  @DefaultStringValue("New")
  String newButtonTooltip();

  @DefaultStringValue("Run Workflow...")
  String workflowButton();
  @DefaultStringValue("Run Workflow")
  String workflowButtonTooltip();

  @DefaultStringValue("Reports")
  String reportsButton();
  @DefaultStringValue("Reports")
  String reportsButtonTooltip();

  @DefaultStringValue("Print Preview")
  String printPreviewButtonTooltip();
  @DefaultStringValue("Export")
  String exportButtonTooltip();
  @DefaultStringValue("Mail Merge")
  String mailMergeButtonTooltip();
  @DefaultStringValue("Assign")
  String assignButtonTooltip();
  @DefaultStringValue("Delete")
  String deleteButtonTooltip();
  @DefaultStringValue("Email")
  String emailButtonTooltip();
  @DefaultStringValue("Attach")
  String attachButtonTooltip();
  @DefaultStringValue("Refresh")
  String refreshButtonTooltip();

  // Entity ToolBar


  // @DefaultStringValue("Save")
  // String saveButton();
  @DefaultStringValue("Save and Close")
  String saveAndCloseButton();

  @DefaultStringValue("Help")
  String helpButton();

  @DefaultStringValue("Save")
  String saveButtonTooltip();
  @DefaultStringValue("Save and Close")
  String saveAndCloseButtonTooltip();
  @DefaultStringValue("Help")
  String helpButtonTooltip();

  //
  // Account entity tabs
  //

  @DefaultStringValue("Account: ")
  String accountWindowTitle();

  @DefaultStringValue("New Account")
  String newAccount();

  @DefaultStringValue("General")
  String generalTab();

  @DefaultStringValue("General Information")
  String generalInformationSectionItem();

  @DefaultStringValue("Account Name")
  String accountNameLabel();
  @DefaultStringValue("Account Number")
  String accountNumberLabel();
  @DefaultStringValue("Parent Account")
  String parentAccountLabel();
  @DefaultStringValue("Primary Contact")
  String primaryContactLabel();
  @DefaultStringValue("Relationship Type")
  String relationshipTypeLabel();
  @DefaultStringValue("Main Phone")
  String mainPhoneLabel();
  @DefaultStringValue("Other Phone")
  String otherPhoneLabel();
  @DefaultStringValue("Fax")
  String faxLabel();
  @DefaultStringValue("Web Site")
  String webSiteLabel();
  @DefaultStringValue("Email")
  String emailLabel();

  @DefaultStringValue("Address Information")
  String addressInformationSectionItem();

  @DefaultStringValue("Address Name")
  String addressNameLabel();
  @DefaultStringValue("Street 1")
  String addressLine1Label();
  @DefaultStringValue("Street 2")
  String addressLine2Label();
  @DefaultStringValue("Street 3")
  String addressLine3Label();
  @DefaultStringValue("City")
  String cityLabel();
  @DefaultStringValue("State/Province")
  String stateLabel();
  @DefaultStringValue("ZIP/Postal Code")
  String postalCodeLabel();
  @DefaultStringValue("Country/Region")
  String countryLabel();
  @DefaultStringValue("Address Type")
  String addressTypeLabel();

  @DefaultStringValue("Administration")
  String administrationTab();

  @DefaultStringValue("Notes")
  String notesTab();

  //
  // Email entity tabs
  //

  @DefaultStringValue("Email: ")
  String emailWindowTitle();

  @DefaultStringValue("New Email")
  String newEmail();

  @DefaultStringValue("Email")
  String emailTab();

  // @DefaultStringValue("General Information")
  // String generalInformationSectionItem();

  @DefaultStringValue("From")
  String fromLabel();
  @DefaultStringValue("To")
  String toLabel();
  @DefaultStringValue("Subject")
  String subjectLabel();
  @DefaultStringValue("Regarding")
  String regardingLabel();
  @DefaultStringValue("Owner")
  String ownerLabel();
  @DefaultStringValue("Duration")
  String durationLabel();
  @DefaultStringValue("Due")
  String dueDateLabel();
  @DefaultStringValue("Category")
  String categoryLabel();



  @DefaultStringValue("Cc")
  String ccLabel();
  @DefaultStringValue("Bcc")
  String bccLabel();
  @DefaultStringValue("Priority")
  String priorityLabel();
  @DefaultStringValue("Sub-Category")
  String subCategoryLabel();



  @DefaultStringValue("Attachments")
  String attachmentsTab();


  // Activities Context Area Grid - Header Labels
  @DefaultStringValue("Activity Type")
  String activityType();
  @DefaultStringValue("Subject")
  String subject();
  @DefaultStringValue("Regarding")
  String regarding();
  @DefaultStringValue("Priority")
  String priority();
  @DefaultStringValue("Start Date")
  String startDate();
  @DefaultStringValue("Due Date")
  String dueDate();

  // Accounts Context Area Grid - Header Labels
  @DefaultStringValue("Account Name")
  String accountName();
  @DefaultStringValue("Main Phone")
  String mainPhone();
  @DefaultStringValue("Location")
  String location();
  @DefaultStringValue("Primary Contact")
  String primaryContact();
  @DefaultStringValue("Email (Primary Contact)")
  String emailPrimaryContact();

  // Contacts Context Area Grid - Header Labels
  @DefaultStringValue("Full Name")
  String fullName();
  @DefaultStringValue("Parent Customer")
  String parentCustomer();
  @DefaultStringValue("City")
  String city();
  @DefaultStringValue("Phone")
  String phone();
  // @DefaultStringValue("Location")
  // String location();
  @DefaultStringValue("Business Phone")
  String businessPhone();
  @DefaultStringValue("Email")
  String email();

  // Reports Context Area Grid - Header Labels
  @DefaultStringValue("Report Name")
  String reportName();
  @DefaultStringValue("Report Type")
  String reportType();
  @DefaultStringValue("Modified On")
  String modifiedOn();
  @DefaultStringValue("Description")
  String description();

  // Imports Context Area Grid - Header Labels
  @DefaultStringValue("Import Name")
  String importName();
  @DefaultStringValue("Status")
  String status();
  @DefaultStringValue("Successes")
  String successes();
  @DefaultStringValue("Errors")
  String errors();
  @DefaultStringValue("Total")
  String total();
  @DefaultStringValue("Created On")
  String createdOn();

  // Common

  @DefaultStringValue("OK")
  String ok();

  @DefaultStringValue("Cancel")
  String cancel();

  @DefaultStringValue("No items to show.")
  String gridEmptyText();

  // SignInPageView

  @DefaultStringValue("Sign in")
  String signIn();

  @DefaultStringValue("You must enter a valid User name and Password.")
  String signInPrompt();

  // AccountsView

  @DefaultStringValue("Are you sure you want to delete this Account?")
  String deleteAccountPrompt();

  // AccountInformationView

  @DefaultStringValue("<br /><b>Information</b>")
  String informationLabel();

  // FileUploadPageView

  @DefaultStringValue("Upload Data File")
  String fileUploadWindowTitle();

  @DefaultStringValue("Select a Data File to Upload")
  String fileUploadHeaderLine1Label();

  @DefaultStringValue("Select a data file to be imported into the application.")
  String fileUploadHeaderLine2Label();

  @DefaultStringValue("Record type")
  String recordTypeLabel();

  @DefaultStringValue("Account")
  String accountLabel();

  @DefaultStringValue("Data map")
  String dataMapLabel();

  @DefaultStringValue("Automatic")
  String automaticLabel();

  @DefaultStringValue("File name")
  String fileNameLabel();

  @DefaultStringValue("Please select a file.")
  String selectAFilePrompt();

}